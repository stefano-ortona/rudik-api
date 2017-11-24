package asu.edu.rule_miner.api.impl.configuration;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

import asu.edu.rule_miner.api.RudikApiException;
import asu.edu.rule_miner.api.model.GraphSpecification;
import asu.edu.rule_miner.api.model.GraphSpecification.NameEnum;
import asu.edu.rule_miner.api.model.RelationPrefix;
import asu.edu.rule_miner.api.model.RuleSpecification;
import asu.edu.rule_miner.rudik.configuration.ConfigurationFacility;

/**
 *
 * @author Stefano Ortona
 *
 *         Utility class to set all configuration parameters to invoke RuDiK
 *
 */
public class ConfigurationHelper {

  private final static Logger LOGGER = LoggerFactory.getLogger(ConfigurationHelper.class.getName());

  private final Map<NameEnum, String> graph2configuration;

  public ConfigurationHelper() {
    this.graph2configuration = Maps.newHashMap();
    this.graph2configuration.put(NameEnum.DBPEDIA, "src/main/config/DbpediaConfiguration.xml");
    this.graph2configuration.put(NameEnum.YAGO, "src/main/config/YagoConfiguration.xml");
    this.graph2configuration.put(NameEnum.WIKIMETA, "src/main/config/WikidataConfiguration.xml");
    this.graph2configuration.put(NameEnum.FREEBASE, "src/main/config/FreebaseConfiguration.xml");
  }

  /**
   * Utility method to convert all input specified parameters into configuration parameters used by the system
   *
   * @param ruleSpec
   * @throws RudikApiException
   */
  public void convertSpecificationConfiguration(final RuleSpecification ruleSpec) throws RudikApiException {
    if (ruleSpec == null) {
      return;
    }
    final Integer maxRuleLen = ruleSpec.getMaxLength();
    if (maxRuleLen != null) {
      ConfigurationFacility.setMaxRuleLength(maxRuleLen);
    }
    final GraphSpecification graphSpec = ruleSpec.getGraph();
    if (graphSpec == null) {
      return;
    }
    final Double alpha = graphSpec.getAlpha();
    final Double beta = graphSpec.getBeta();
    if ((alpha != null) && (beta != null)) {
      // alpha and beta parameter can be set only in conjuction
      ConfigurationFacility.setAlphaBetaParameter(alpha, beta);
    }
    final List<String> avoidRelation = graphSpec.getAvoidRelation();
    if (avoidRelation != null) {
      ConfigurationFacility.setRelationToAvoid(avoidRelation);
    }
    final Integer disequality = graphSpec.getDisequalityRelation();
    if (disequality != null) {
      ConfigurationFacility.setDisequalityRelation(disequality);
    }
    final List<String> genericTypes = graphSpec.getGenericType();
    if (genericTypes != null) {
      ConfigurationFacility.setGraphGenericTypes(genericTypes);
    }
    final Integer incomingEdgesLimit = graphSpec.getIncomingEdges();
    if (incomingEdgesLimit != null) {
      ConfigurationFacility.setIncomingEdgesLimit(incomingEdgesLimit);
    }
    final String graphIri = graphSpec.getIri();
    if (graphIri != null) {
      ConfigurationFacility.setGraphIri(graphIri);
    }
    final Boolean includeLiteral = graphSpec.getLiteral();
    if (includeLiteral != null) {
      ConfigurationFacility.setIncludeLiteral(includeLiteral);
    }
    final Integer outgoingEdgesLimit = graphSpec.getOutgoingEdges();
    if (outgoingEdgesLimit != null) {
      ConfigurationFacility.setOutgoingEdgesLimit(outgoingEdgesLimit);
    }
    final List<RelationPrefix> prefixes = graphSpec.getPrefix();
    if (prefixes != null) {
      final Map<String, String> name2uri = Maps.newHashMap();
      prefixes.forEach(pref -> {
        name2uri.put(pref.getName(), pref.getUri());
      });
      ConfigurationFacility.setGraphPrefixes(name2uri);
    }
    final List<String> targetPrefix = graphSpec.getTargetPrefix();
    if (targetPrefix != null) {
      ConfigurationFacility.setRelationTargetPrefix(targetPrefix);
    }
    final String typePrefixes = graphSpec.getTypePrefix();
    if (typePrefixes != null) {
      ConfigurationFacility.setTypeRelationPrefixes(typePrefixes);
    }

  }

  public void setGraphConfiguration(final GraphSpecification graphSpec) throws RudikApiException {
    if ((graphSpec == null) || (graphSpec.getName() == null)) {
      throw new RudikApiException("Graph specification with specific graph name must be provided.", LOGGER);
    }
    final NameEnum graphName = graphSpec.getName();
    if ((graphName == NameEnum.OTHER) && ((graphSpec.getEndpoint() == null) || graphSpec.getEndpoint().isEmpty())) {
      // cannot use OTHER graph without specifying SPARQL endpoint
      throw new RudikApiException("Cannot use 'OTHER' as name of the graph without specifying a SPARQL endpoint.",
          LOGGER);
    }
    final String confFile = graph2configuration.get(graphName);
    if (confFile != null) {
      LOGGER.debug("Configuration file for graph '{}' set to '{}'.", graphName, confFile);
      ConfigurationFacility.setConfigurationFile(confFile);
    } else {
      if (graphName == NameEnum.OTHER) {
        // specify the new endpoint
        final String newEndpoint = graphSpec.getEndpoint();
        ConfigurationFacility.setSparqlEndpoint(newEndpoint);
        LOGGER.info("Other graph specified with SPARQL endpoint set to '{}'.", newEndpoint);
      }
    }
  }

}
