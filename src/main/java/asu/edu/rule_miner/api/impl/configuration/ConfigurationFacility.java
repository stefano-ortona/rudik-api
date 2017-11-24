package asu.edu.rule_miner.api.impl.configuration;

import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import asu.edu.rule_miner.api.RudikApiException;
import asu.edu.rule_miner.api.impl.utils.Constant;

public class ConfigurationFacility {

  private final static Logger LOGGER = LoggerFactory.getLogger(ConfigurationFacility.class.getName());

  private static XMLConfiguration applicationConfiguration;

  public static XMLConfiguration getInstance() {
    if (applicationConfiguration == null) {
      // for logging purposes
      asu.edu.rule_miner.rudik.configuration.ConfigurationFacility.getConfiguration();
      // load configuration
      final String applicationConfigurationPath = Constant.APPLICATION_CONFIGURATION;
      if ((applicationConfigurationPath == null) || applicationConfigurationPath.isEmpty()) {
        throw new RudikApiException(StringUtils.join("Application configuration environment has not be set at ",
            Constant.APPLICATION_CONFIGURATION_ENV_NAME, ", cannot read configuration file."), LOGGER);
      }
      // load XML configuration
      try {
        final XMLConfiguration config = new XMLConfiguration(applicationConfigurationPath);
        applicationConfiguration = config;
      } catch (final Exception cex) {
        throw new RudikApiException(
            StringUtils.join("Exception while creating XML configuration at ", applicationConfigurationPath, "."), cex);
      }
    }
    return applicationConfiguration;
  }

}
