package asu.edu.rule_miner.api.impl;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import asu.edu.rule_miner.api.RudikApiException;
import asu.edu.rule_miner.api.impl.configuration.ConfigurationHelper;
import asu.edu.rule_miner.api.impl.utils.RudikApiUtils;
import asu.edu.rule_miner.api.model.GraphSpecification;
import asu.edu.rule_miner.api.model.RuleSpecification;
import asu.edu.rule_miner.rudik.configuration.ConfigurationFacility;

public class ApiServiceUtils {

  private final static ConfigurationHelper CONF_HELPER = new ConfigurationHelper();
  private static final Logger LOGGER = LoggerFactory.getLogger(ExampleApiServiceImpl.class);

  /**
   * Initialise graph configuration
   * @param graphSpec
   * @return null if everything went fine, an error response otherwise
   */
  public static Response initaliseGraphConfiguration(final GraphSpecification graphSpec) {
    ConfigurationFacility.resetConfiguration();
    try {
      CONF_HELPER.setGraphConfiguration(graphSpec);
    } catch (final RudikApiException e) {
      LOGGER.error("Error while configuring graph configuration.", e);
      return RudikApiUtils.errorResponseFrom(Response.Status.PRECONDITION_FAILED, e.getMessage());
    }
    return null;
  }

  public static void setConfigurationParameter(final RuleSpecification ruleSpec) {
    CONF_HELPER.convertSpecificationConfiguration(ruleSpec);
  }

}
