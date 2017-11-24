package asu.edu.rule_miner.api.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.jena.sparql.engine.http.QueryExceptionHTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import asu.edu.rule_miner.api.ExampleApiService;
import asu.edu.rule_miner.api.NotFoundException;
import asu.edu.rule_miner.api.impl.utils.RudikApiUtils;
import asu.edu.rule_miner.api.model.EntityPair;
import asu.edu.rule_miner.api.model.RuleExample;
import asu.edu.rule_miner.api.model.RuleSpecification;
import asu.edu.rule_miner.rudik.predicate.analysis.KBPredicateSelector;
import asu.edu.rule_miner.rudik.predicate.analysis.SparqlKBPredicateSelector;
import asu.edu.rule_miner.rudik.rule_generator.DynamicPruningRuleDiscovery;
import jersey.repackaged.com.google.common.collect.Lists;
import jersey.repackaged.com.google.common.collect.Sets;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class ExampleApiServiceImpl extends ExampleApiService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExampleApiServiceImpl.class);

  @Override
  public Response exampleGeneration(RuleSpecification predicateSpecification, SecurityContext securityContext)
      throws NotFoundException {
    if (predicateSpecification == null) {
      // Return HTTP 400.
      LOGGER.error("A predicate specification is required.");
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED,
          "A predicate specification is required.");
    }
    final Response resp = ApiServiceUtils.initaliseGraphConfiguration(predicateSpecification.getGraph());
    if (resp != null) {
      return resp;
    }
    // create rudik objects after setting the configuration
    final DynamicPruningRuleDiscovery rudik = new DynamicPruningRuleDiscovery();
    // get target predicates
    final List<String> targetPredicates = predicateSpecification.getTargetRelation();
    if ((targetPredicates == null) || targetPredicates.isEmpty()) {
      LOGGER.error("Target predicates cannont be null or empty.");
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED,
          "Target predicates cannont be null or empty.");
    }
    try {
      // check type subject and object are specified
      String subType = predicateSpecification.getSubjectType();
      String objType = predicateSpecification.getObjectType();
      if ((subType == null) || (objType == null)) {
        final KBPredicateSelector predicateSel = new SparqlKBPredicateSelector();
        final Pair<String, String> types = predicateSel.getPredicateTypes(targetPredicates.get(0));
        subType = subType == null ? types.getLeft() : subType;
        objType = objType == null ? types.getRight() : objType;
      }

      // get max number of examples, otherwise set it to -1
      Integer posExamplesLimit = predicateSpecification.getGraph().getPositiveExamplesLimit();
      posExamplesLimit = posExamplesLimit == null ? -1 : posExamplesLimit;
      Integer negExamplesLimit = predicateSpecification.getGraph().getNegativeExamplesLimit();
      negExamplesLimit = negExamplesLimit == null ? -1 : negExamplesLimit;

      // set configuration parameters
      ApiServiceUtils.setConfigurationParameter(predicateSpecification);
      LOGGER.info(
          "Computing positive and negative examples for predicates '{}' with: subjType '{}', objType '{}', posLimit '{}', negLimit '{}'.",
          targetPredicates, subType, objType, posExamplesLimit, negExamplesLimit);

      // compute pos examples
      Set<Pair<String, String>> posExamples = null;
      posExamples = rudik.generatePositiveExamples(Sets.newHashSet(targetPredicates), subType, objType,
          posExamplesLimit);

      // compute neg examples
      Set<Pair<String, String>> negExamples = null;
      negExamples = rudik.generateNegativeExamples(Sets.newHashSet(targetPredicates), subType, objType,
          negExamplesLimit);

      LOGGER.info("Computed {} positive examples and {} negative examples.", posExamples.size(), negExamples.size());
      // build response with positive and negative examples
      final RuleExample examples = new RuleExample().positive(buildExamples(posExamples))
          .negative(buildExamples(negExamples));
      return Response.status(Response.Status.OK).entity(examples).build();
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
  public Response exampleType(RuleSpecification predicateSpecification, SecurityContext securityContext)
      throws NotFoundException {
    if (predicateSpecification == null) {
      // Return HTTP 400.
      LOGGER.error("A predicate specification is required.");
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED,
          "A predicate specification is required.");
    }
    final Response resp = ApiServiceUtils.initaliseGraphConfiguration(predicateSpecification.getGraph());
    if (resp != null) {
      return resp;
    }
    // get target predicates
    final List<String> targetPredicates = predicateSpecification.getTargetRelation();
    if ((targetPredicates == null) || targetPredicates.isEmpty()) {
      LOGGER.error("Target predicates cannont be null or empty.");
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED,
          "Target predicates cannont be null or empty.");
    }
    try {
      // set configuration parameters
      ApiServiceUtils.setConfigurationParameter(predicateSpecification);
      LOGGER.info("Computing subject and object type for predicate '{}'.", targetPredicates.get(0));
      // compute subject and object type
      final KBPredicateSelector predicateSel = new SparqlKBPredicateSelector();
      final Pair<String, String> types = predicateSel.getPredicateTypes(targetPredicates.get(0));

      LOGGER.info("Computed subject and object type: '{}'.", types);
      // build response
      final EntityPair pair = new EntityPair().subject(types.getLeft()).object(types.getRight());
      return Response.status(Response.Status.OK).entity(pair).build();
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

  private List<EntityPair> buildExamples(final Collection<Pair<String, String>> examples) {
    if (examples == null) {
      return Lists.newArrayList();
    }
    final List<EntityPair> allExamples = Lists.newLinkedList();
    examples.forEach(e -> {
      allExamples.add(new EntityPair().subject(e.getLeft()).object(e.getRight()));
    });
    return allExamples;
  }
}
