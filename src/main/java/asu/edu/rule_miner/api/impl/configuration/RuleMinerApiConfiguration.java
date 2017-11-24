package asu.edu.rule_miner.api.impl.configuration;

import org.apache.commons.configuration.ConfigurationRuntimeException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.beanutils.BeanDeclaration;
import org.apache.commons.configuration.beanutils.BeanHelper;
import org.apache.commons.configuration.beanutils.XMLBeanDeclaration;
import org.apache.commons.lang3.StringUtils;

import asu.edu.rule_miner.api.RudikApiException;
import lombok.Data;

@Data
public class RuleMinerApiConfiguration {

  private static final String RUDIK_STORAGE_S3_BUCKET_NAME = "fhai-rudik-output-rules";

  private static final String RUDIK_STORAGE_FILE_EXTENSION = "json";

  private static final String RUDIK_STORAGE_CREDENTIALS_FILE = "src/main/config/s3_credentials";

  private static final String RUDIK_STORAGE_S3_REGIONES = "eu-west-1";

  /** Configuration prefix */
  private static final String CONFIG_PREFIX = "rudik.api.service";

  /** Singleton instance. */
  private static volatile RuleMinerApiConfiguration instance;

  /**
   * Return a singleton instance of ServiceConfiguration.
   */
  public static RuleMinerApiConfiguration getInstance() {
    // Double lock for thread safety.
    if (instance == null) {
      synchronized (RuleMinerApiConfiguration.class) {
        if (instance == null) {
          try {
            final XMLConfiguration config = ConfigurationFacility.getInstance();
            final BeanDeclaration decl = new XMLBeanDeclaration(config, CONFIG_PREFIX);
            instance = (RuleMinerApiConfiguration) BeanHelper.createBean(decl, RuleMinerApiConfiguration.class);
          } catch (final ConfigurationRuntimeException cre) {
            throw new RudikApiException(
                StringUtils.join("Exception while creating bean configuration at prefix", CONFIG_PREFIX, "."), cre);
          }
        }
      }
    }
    return instance;
  }

  public String bucketName = RUDIK_STORAGE_S3_BUCKET_NAME;
  
  public String fileExtension = RUDIK_STORAGE_FILE_EXTENSION;
  
  public String credentialsFile = RUDIK_STORAGE_CREDENTIALS_FILE;
  
  public String s3Regions = RUDIK_STORAGE_S3_REGIONES;

}
