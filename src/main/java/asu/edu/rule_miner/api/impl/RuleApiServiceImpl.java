package asu.edu.rule_miner.api.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.jena.sparql.engine.http.QueryExceptionHTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import asu.edu.rule_miner.api.NotFoundException;
import asu.edu.rule_miner.api.RuleApiService;
import asu.edu.rule_miner.api.impl.model.RGIdGenerator;
import asu.edu.rule_miner.api.impl.model.RuleGeneratorWorker;
import asu.edu.rule_miner.api.impl.model.RuleStorage;
import asu.edu.rule_miner.api.impl.model.S3UtilityStorage;
import asu.edu.rule_miner.api.impl.utils.Constant;
import asu.edu.rule_miner.api.impl.utils.RudikApiUtils;
import asu.edu.rule_miner.api.model.EntityPair;
import asu.edu.rule_miner.api.model.HornRule;
import asu.edu.rule_miner.api.model.HornRuleAtom;
import asu.edu.rule_miner.api.model.KeyValuePair;
import asu.edu.rule_miner.api.model.RuleInstantiation;
import asu.edu.rule_miner.api.model.RuleResult;
import asu.edu.rule_miner.api.model.RuleSpecification;
import asu.edu.rule_miner.api.model.RuleSpecification.TypeEnum;
import asu.edu.rule_miner.api.model.RuleStatus;
import asu.edu.rule_miner.api.model.Status;
import asu.edu.rule_miner.api.model.VariableBinding;
import asu.edu.rule_miner.rudik.model.horn_rule.RuleAtom;
import asu.edu.rule_miner.rudik.rule_generator.DynamicPruningRuleDiscovery;
import asu.edu.rule_miner.rudik.rule_generator.HornRuleDiscoveryInterface;
import jersey.repackaged.com.google.common.collect.Sets;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class RuleApiServiceImpl extends RuleApiService {

  private static final Logger LOGGER = LoggerFactory.getLogger(RuleApiServiceImpl.class);
  private final RGIdGenerator idGen = new RGIdGenerator();
  private final RuleStorage storage = new S3UtilityStorage();
  private Future<?> aliveRunnable = null;

  @Override
  public Response instantiateRule(RuleResult ruleSpecification, SecurityContext securityContext)
      throws NotFoundException {
    if ((ruleSpecification == null) || (ruleSpecification.getSpecification() == null)) {
      // Return HTTP 400.
      LOGGER.error("A rule result specification with its rule specification are both required.");
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED,
          "A predicate specification is required.");
    }
    final Response resp = ApiServiceUtils.initaliseGraphConfiguration(ruleSpecification.getSpecification().getGraph());
    if (resp != null) {
      return resp;
    }
    // get target predicates
    final List<String> targetPredicates = ruleSpecification.getSpecification().getTargetRelation();
    if ((targetPredicates == null) || targetPredicates.isEmpty()) {
      LOGGER.error("Target predicates cannont be null or empty.");
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED,
          "Target predicates cannont be null or empty.");
    }
    final String subjType = ruleSpecification.getSpecification().getSubjectType();
    final String objType = ruleSpecification.getSpecification().getObjectType();
    final TypeEnum ruleType = ruleSpecification.getSpecification().getType();
    // must specify the type of the rule
    if (ruleType == null) {
      LOGGER.error("Rule type cannont be null.");
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED, "Rule type cannont be null.");
    }
    // get the rule
    final asu.edu.rule_miner.rudik.model.horn_rule.HornRule curRule = new asu.edu.rule_miner.rudik.model.horn_rule.HornRule();
    final List<HornRule> rule = ruleSpecification.getRule();
    if (rule == null) {
      LOGGER.error("Rule atoms cannont empty or null.");
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED, "Rule atoms cannont empty or null.");
    }
    try {
      for (final HornRule oneRule : rule) {
        for (final HornRuleAtom oneAtom : oneRule.getBody().getAtom()) {
          final RuleAtom atom = new RuleAtom(oneAtom.getVariablePair().getSubject(), oneAtom.getPredicate(),
              oneAtom.getVariablePair().getObject());
          curRule.addRuleAtom(atom);
        }
      }
      final HornRuleDiscoveryInterface discovery = new DynamicPruningRuleDiscovery();
      // set configuration parameters
      ApiServiceUtils.setConfigurationParameter(ruleSpecification.getSpecification());
      LOGGER.info(
          "Computing rule instantations for predicate atoms '{}' with: target predicates: '{}', rule type: '{}', subType: '{}', objType: '{}'.",
          curRule, targetPredicates, ruleType, subjType, objType);
      final List<List<Pair<String, String>>> allBindings = discovery.instantiateRule(Sets.newHashSet(targetPredicates),
          curRule, subjType, objType, ruleType == TypeEnum.POSITIVE);

      LOGGER.info("Rule instantation computed with {} binding results.", allBindings.size());
      // build response
      final RuleInstantiation instantation = new RuleInstantiation().specification(ruleSpecification);
      allBindings.forEach(b -> {
        final VariableBinding bind = new VariableBinding();
        b.forEach(pair -> {
          bind.addBindingItem(new EntityPair().subject(pair.getLeft()).object(pair.getRight()));
        });
        instantation.addInstanceItem(bind);
      });
      return Response.status(Response.Status.OK).entity(instantation).build();
    } catch (final Exception e) {
      if (e instanceof QueryExceptionHTTP) {
        // server not reachable
        LOGGER.error("HTTP Sparql server not reachable: " + e.getMessage());
        return RudikApiUtils.errorResponseFrom(Response.Status.REQUEST_TIMEOUT,
            "HTTP Sparql server not reachable: " + e.getMessage());
      }
      // general exception
      LOGGER.error("Internal server error: " + e.getMessage());
      return RudikApiUtils.errorResponseFrom(Response.Status.INTERNAL_SERVER_ERROR, "Internal server error.");
    }
  }

  @Override
  public synchronized Response mineRule(RuleSpecification ruleSpecification, Boolean forceMining,
      SecurityContext securityContext) throws NotFoundException {
    if (ruleSpecification == null) {
      // Return HTTP 400.
      LOGGER.error("A rule result specification with its rule specification are both required.");
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED,
          "A predicate specification is required.");
    }
    // target predicates and rule type are the only mandatory parameters
    final List<String> targetRelation = ruleSpecification.getTargetRelation();
    if ((targetRelation == null) || targetRelation.isEmpty()) {
      LOGGER.error("Target relations field must be specified, cannot be empty or null.");
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED,
          "Target relations field must be specified, cannot be empty or null.");
    }
    final TypeEnum ruleType = ruleSpecification.getType();
    if (ruleType == null) {
      LOGGER.error("Rule type field must be specified as either POSITIVE or NEGATIVE.");
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED,
          "Rule type field must be specified as either POSITIVE or NEGATIVE.");
    }
    final String graphName = ruleSpecification.getGraph() != null ? ruleSpecification.getGraph().getName().toString()
        : null;
    LOGGER.info("Computing rules for type '{}' and target predicates '{}' on graph '{}'.", ruleType, targetRelation,
        graphName);
    final String ruleId = idGen.generateAndSetId(ruleSpecification);
    if ((forceMining == null) || (forceMining == false)) {
      // first check the existence of the rule
      final RuleResult storedResult = storage.getStoredResult(ruleSpecification, ruleId);
      if (storedResult != null) {
        // rules already computed previously, return the response
        LOGGER.info(
            "Rules for type '{}' and target predicates '{}' already computed with id '{}', returning the response.",
            ruleType, targetRelation, ruleId);
        // check there were no errors computing rules
        final String previousErrorMsg = getServerError(storedResult);
        if (previousErrorMsg != null) {
          // return an error response
          return RudikApiUtils.errorResponseFrom(Response.Status.INTERNAL_SERVER_ERROR,
              StringUtils.join("Internal server error: ", previousErrorMsg));
        }
        // no errors, return OK status
        return Response.status(Response.Status.OK).entity(storedResult).build();
      }
    }
    // rules must be computed
    // one instance can compute only rules one at time
    if (instanceBusy()) {
      LOGGER.info("Current instance is busy computing rules for other predicates, cannot accept request.");
      return RudikApiUtils.errorResponseFrom(Response.Status.SERVICE_UNAVAILABLE,
          "Current instance is busy computing rules for other predicates, cannot accept request.");
    }
    try {
      // set endpoint result
      ruleSpecification.setResultEndpoint(storage.getEndpointResult(ruleSpecification, ruleId));
      // start a separate thread that will compute rules
      final Response resp = ApiServiceUtils.initaliseGraphConfiguration(ruleSpecification.getGraph());
      if (resp != null) {
        return resp;
      }
      ApiServiceUtils.setConfigurationParameter(ruleSpecification);
      final ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
          new LinkedBlockingQueue<Runnable>());
      final Runnable newRunnable = new RuleGeneratorWorker(storage, ruleSpecification);
      final Future<?> future = executor.submit(newRunnable);
      this.aliveRunnable = future;
      final String msgStatus = StringUtils.join(
          "The request with specified parameters has been successfully received and the rules computation has started, results will be published at <",
          ruleSpecification.getResultEndpoint(), ">.");
      LOGGER.info(msgStatus);
      final Status status = new Status().code("Submitted").description(msgStatus);
      return Response.status(202).entity(new RuleStatus().rule(ruleSpecification).status(status)).build();
    } catch (final Exception e) {
      // general exception
      LOGGER.error("Internal server error: " + e.getMessage());
      return RudikApiUtils.errorResponseFrom(Response.Status.INTERNAL_SERVER_ERROR, "Internal server error.");
    }
  }

  private String getServerError(RuleResult result) {
    if (result.getMetadata() != null) {
      final Optional<KeyValuePair> errorMsg = result.getMetadata().stream()
          .filter(e -> e.getKey().equals(Constant.ERROR_MESSAGE)).findFirst();
      if (errorMsg.isPresent()) {
        return errorMsg.get().getValue();
      }
    }
    return null;
  }

  /**
   * Check whether the current instance is busy by analyzing the number of alive threads
   * @return
   */
  private boolean instanceBusy() {
    if ((this.aliveRunnable != null) && !this.aliveRunnable.isDone()) {
      // there are alive runnables
      return true;
    }
    // clear alive thread
    this.aliveRunnable = null;
    return false;
  }
}
