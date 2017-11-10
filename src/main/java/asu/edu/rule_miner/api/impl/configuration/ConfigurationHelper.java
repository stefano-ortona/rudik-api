package asu.edu.rule_miner.api.impl.configuration;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

import asu.edu.api.model.GraphSpecification;
import asu.edu.api.model.GraphSpecification.NameEnum;
import asu.edu.api.model.RuleSpecification;
import asu.edu.rule_miner.api.RudikApiException;
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

  public void setConfigurationParameter(final RuleSpecification ruleSpec) throws RudikApiException {

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
    }
  }

}
