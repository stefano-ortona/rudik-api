package asu.edu.rule_miner.api.impl.model;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import com.google.common.hash.Hashing;

import asu.edu.rule_miner.api.impl.utils.Base58;
import asu.edu.rule_miner.api.model.GraphSpecification;
import asu.edu.rule_miner.api.model.GraphSpecification.NameEnum;
import asu.edu.rule_miner.api.model.RuleSpecification;

/**
 * @author Stefano Ortona <stefano.ortona@gmail.com>
 *
 * Rule Graph Id Generator class, responsible of creating a specific id given a graph configuration or a rule configuration
 */
public class RGIdGenerator {

  private final static String GRAPH_PREFIX = "g";
  private final static String RULE_PREFIX = "r";
  private final static String ID_SEPARATOR = "_";

  /**
   * Generate and set an id for the input rule specification and for the contained graph specification, if specified
   * The current id is set as <graphId_h>, where h is a hash over all the fields specified in the rule specification
   *
   * @param ruleSpec
   * @return
   */
  public String generateAndSetId(final RuleSpecification ruleSpec) {
    if (ruleSpec.getTargetRelation() == null) {
      throw new IllegalArgumentException("Target relations cannot be null to generate an ID. ");
    }
    if ((ruleSpec == null) || (ruleSpec.getGraph() == null)) {
      throw new IllegalArgumentException(
          "To generate a rule specification ID, we need a graph specification: " + ruleSpec);
    }

    final StringBuilder sb = new StringBuilder();

    // generate graph id
    final String graphId = this.generateAndSetId(ruleSpec.getGraph());

    sb.append(graphId).append(ID_SEPARATOR);

    final StringBuilder relationBuilder = new StringBuilder();
    ruleSpec.getTargetRelation().forEach(r -> relationBuilder.append(r));

    sb.append(RULE_PREFIX).append(
        Base58.encode(Hashing.sha256().hashString(relationBuilder.toString(), StandardCharsets.UTF_8).asBytes()));

    sb.append(ID_SEPARATOR);

    sb.append(Base58.encode(Integer.toHexString(getHashCodeWithoutTargetPredicates(ruleSpec)).getBytes()));

    final String ruleId = sb.toString();
    ruleSpec.setId(ruleId);
    return ruleId;
  }

  /**
   * Generate and set an id for the given graph specification.
   * The current id is set as a hash over all the fields of the graph
   *
   * @param graphSpec
   * @return
   */
  public String generateAndSetId(final GraphSpecification graphSpec) {
    if (graphSpec == null) {
      return null;
    }

    final NameEnum graphName = graphSpec.getName();
    String graphNameString = graphName.toString();
    if (graphName == NameEnum.OTHER) {
      graphNameString += graphSpec.getEndpoint();
    }

    final StringBuilder sb = new StringBuilder(GRAPH_PREFIX);

    sb.append(Base58.encode(Hashing.sha256().hashString(graphNameString, StandardCharsets.UTF_8).asBytes()));

    sb.append(ID_SEPARATOR);

    sb.append(Base58.encode(Integer.toHexString(getHashCodeWithoutGraphName(graphSpec)).getBytes()));

    final String graphId = sb.toString();
    graphSpec.setId(graphId);
    return graphId;
  }

  private int getHashCodeWithoutGraphName(final GraphSpecification graphSpec) {
    // negative and positive examples limit have no effect if they are set to a number <= 0 or they are not specified
    final Integer posLimit = graphSpec.getPositiveExamplesLimit();
    final int acutalPosLimit = (posLimit == null) || (posLimit <= 0) ? -1 : posLimit;
    final Integer negLimit = graphSpec.getNegativeExamplesLimit();
    final int acutalNegLimit = (negLimit == null) || (negLimit <= 0) ? -1 : negLimit;
    return Objects.hash(graphSpec.getAlpha(), graphSpec.getAvoidRelation(), graphSpec.getBeta(),
        graphSpec.getDisequalityRelation(), graphSpec.getGenericType(), graphSpec.getIncomingEdges(),
        graphSpec.getIri(), graphSpec.getLiteral(), acutalNegLimit, graphSpec.getOutgoingEdges(), acutalPosLimit,
        graphSpec.getTargetPrefix(), graphSpec.getTypePrefix());
  }

  private int getHashCodeWithoutTargetPredicates(final RuleSpecification ruleSpec) {
    // kbound has same effect for all numbers specified <=0
    Integer actualKBound = ruleSpec.getCoverBound();
    if (actualKBound != null) {
      actualKBound = actualKBound <= 0 ? -1 : actualKBound;
    }
    return Objects.hash(ruleSpec.getMaxLength(), ruleSpec.getNegativeExamples(), ruleSpec.getPositiveExamples(),
        ruleSpec.getSubjectType(), ruleSpec.getObjectType(), ruleSpec.getType().toString(), actualKBound);
  }

}
