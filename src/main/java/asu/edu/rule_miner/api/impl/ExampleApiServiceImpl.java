package asu.edu.rule_miner.api.impl;

import java.util.List;
import java.util.Set;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import asu.edu.api.model.RuleSpecification;
import asu.edu.rule_miner.api.ApiResponseMessage;
import asu.edu.rule_miner.api.ExampleApiService;
import asu.edu.rule_miner.api.NotFoundException;
import asu.edu.rule_miner.api.RudikApiException;
import asu.edu.rule_miner.api.impl.configuration.ConfigurationHelper;
import asu.edu.rule_miner.api.impl.utils.RudikApiUtils;
import asu.edu.rule_miner.rudik.configuration.ConfigurationFacility;
import asu.edu.rule_miner.rudik.predicate.analysis.KBPredicateSelector;
import asu.edu.rule_miner.rudik.predicate.analysis.SparqlKBPredicateSelector;
import asu.edu.rule_miner.rudik.rule_generator.DynamicPruningRuleDiscovery;
import jersey.repackaged.com.google.common.collect.Sets;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class ExampleApiServiceImpl extends ExampleApiService {

  private final ConfigurationHelper confHelper = new ConfigurationHelper();
  private static final Logger LOGGER = LoggerFactory.getLogger(ExampleApiServiceImpl.class);
  private final DynamicPruningRuleDiscovery rudik = new DynamicPruningRuleDiscovery();
  private final KBPredicateSelector predicateSel = new SparqlKBPredicateSelector();

  @Override
  public Response exampleGeneration(RuleSpecification predicateSpecification, SecurityContext securityContext)
      throws NotFoundException {
    if (predicateSpecification == null) {
      // Return HTTP 400.
      LOGGER.error("A predicate specification is required.");
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED,
          "A predicate specification is required.");
    }
    ConfigurationFacility.resetConfiguration();
    try {
      confHelper.setGraphConfiguration(predicateSpecification.getGraph());
    } catch (final RudikApiException e) {
      LOGGER.error("Error while configuring graph configuration.", e);
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED, e.getMessage());
    }
    // get target predicates
    final List<String> targetPredicates = predicateSpecification.getTargetRelation();
    if ((targetPredicates == null) || targetPredicates.isEmpty()) {
      LOGGER.error("Target predicates cannont be null or empty.");
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED,
          "Target predicates cannont be null or empty.");
    }
    // check type subject and object are specified
    String subType = predicateSpecification.getSubjectType();
    String objType = predicateSpecification.getObjectType();
    if ((subType == null) || (objType == null)) {
      final Pair<String, String> types = predicateSel.getPredicateTypes(targetPredicates.get(0));
      subType = subType == null ? types.getLeft() : subType;
      objType = objType == null ? types.getRight() : objType;
    }

    // get max number of pos examples
    final Integer posExamplesLimit = predicateSpecification.getGraph().getPositiveExamplesLimit();
    // compute pos examples
    Set<Pair<String, String>> posExamples = null;
    if (posExamplesLimit != null) {
      posExamples = rudik.generatePositiveExamples(Sets.newHashSet(targetPredicates), subType, objType,
          posExamplesLimit);
    } else {
      posExamples = rudik.generatePositiveExamples(Sets.newHashSet(targetPredicates), subType, objType);
    }

    // get max number of neg examples
    final Integer negExamplesLimit = predicateSpecification.getGraph().getNegativeExamplesLimit();
    // compute neg examples
    Set<Pair<String, String>> negExamples = null;
    if (posExamplesLimit != null) {
      negExamples = rudik.generateNegativeExamples(Sets.newHashSet(targetPredicates), subType, objType,
          negExamplesLimit);
    } else {
      negExamples = rudik.generateNegativeExamples(Sets.newHashSet(targetPredicates), subType, objType);
    }
    // build respose with positive and negative examples
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response exampleType(RuleSpecification predicateSpecification, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }
}
