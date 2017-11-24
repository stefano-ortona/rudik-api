package asu.edu.rule_miner.api.impl.model;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.EC2ContainerCredentialsProviderWrapper;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.auth.PropertiesFileCredentialsProvider;
import com.amazonaws.auth.SystemPropertiesCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.AmazonS3URI;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import asu.edu.rule_miner.api.impl.configuration.RuleMinerApiConfiguration;
import asu.edu.rule_miner.api.impl.utils.JsonMapperUtils;
import asu.edu.rule_miner.api.model.GraphSpecification.NameEnum;
import asu.edu.rule_miner.api.model.RuleResult;
import asu.edu.rule_miner.api.model.RuleSpecification;

public class S3UtilityStorage implements RuleStorage {

  private final static Logger LOGGER = LoggerFactory.getLogger(S3UtilityStorage.class.getName());

  AmazonS3 s3;
  private AWSCredentialsProvider provider;
  private Regions region;

  private final static String BUCKET_NAME = RuleMinerApiConfiguration.getInstance().getBucketName();

  private final static ObjectMapper OBJET_MAPPER = JsonMapperUtils.getMapper();

  private final static ContentType CONTENT_TYPE = ContentType.APPLICATION_JSON;
  private final static String STORAGE_EXTENSION = RuleMinerApiConfiguration.getInstance().getFileExtension();

  private final static String S3_CREDENTIALS_FILE = RuleMinerApiConfiguration.getInstance().getCredentialsFile();
  private final static String S3_REGIONS = RuleMinerApiConfiguration.getInstance().getS3Regions();

  /**
   * Try to retrieve a rule result from the S3 storage if it has been computed before
   * Catch also any possible exception that might come from S3 and return null in case of exception
   *
   * @param ruleSpec
   * @param ruleId
   * @return the ruleResult if exists, null otherwise or in case of exception
   *
   */
  @Override
  public RuleResult getStoredResult(final RuleSpecification ruleSpec, final String ruleId) {
    // get the S3 path
    final String s3Path = buildS3Path(ruleSpec, ruleId);
    LOGGER.debug("Retrieving S3 at '{}'.", s3Path);
    final AmazonS3URI uri = new AmazonS3URI(s3Path);

    initialiseS3Client();
    String objectString;
    try {
      objectString = this.s3.getObjectAsString(uri.getBucket(), uri.getKey());
    } catch (final AmazonServiceException e) {
      if ((e instanceof AmazonS3Exception) && e.getMessage().contains("specified key does not exist")) {
        // key does not exist, do not throw any error message
        LOGGER.debug("Object at '{}' does not exist.", s3Path);
        return null;
      }
      LOGGER.error(StringUtils.join("Could not retrieve S3 object with from url ", s3Path, "."), e);
      return null;
    }
    if (objectString == null) {
      LOGGER.debug("Object at '{}' does not exist.", s3Path);
      return null;
    }
    LOGGER.debug("Successfully retrieved S3 object as '{}'.", s3Path);
    RuleResult result = null;
    try {
      result = OBJET_MAPPER.readValue(objectString, RuleResult.class);
    } catch (final IOException e) {
      LOGGER.error("Could not parse S3 object at '{}' as RuleResult.class, returning null.", s3Path);
      return null;
    }
    return result;
  }

  /**
   * Get the S3 endpoint of where the results for the input rule specification will be stored
   *
   * @param ruleSpecification
   * @param ruleId
   * @return
   */
  @Override
  public String getEndpointResult(RuleSpecification ruleSpecification, String ruleId) {
    return buildS3Path(ruleSpecification, ruleId);
  }

  @Override
  /**
   * Store the given rule result on S3
   */
  public boolean storeRule(RuleResult ruleResult, final String ruleId) {
    if ((ruleResult == null) || (ruleId == null) || (ruleResult.getSpecification() == null)) {
      return false;
    }
    // get the S3 path
    final String s3Path = buildS3Path(ruleResult.getSpecification(), ruleId);
    LOGGER.debug("Storing S3 object at '{}'.", s3Path);
    String objectValue;
    try {
      objectValue = OBJET_MAPPER.writeValueAsString(ruleResult);
    } catch (final JsonProcessingException e) {
      LOGGER.error(StringUtils.join("Could not write value '", ruleResult, "' as RuleResult."), e);
      return false;
    }
    final AmazonS3URI uri = new AmazonS3URI(s3Path);
    final String bucketName = uri.getBucket().toLowerCase();
    final String key = uri.getKey();
    final byte[] byteVal = objectValue.getBytes(StandardCharsets.UTF_8);
    final InputStream bis = new ByteArrayInputStream(byteVal);
    final ObjectMetadata metadata = new ObjectMetadata();
    metadata.setContentLength(byteVal.length);
    metadata.setContentType(CONTENT_TYPE.getMimeType());
    final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, bis, metadata);
    putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead);
    initialiseS3Client();
    if (!this.createBucketIfNotExists(this.s3, bucketName)) {
      // cannot create bucket, return
      return false;
    }
    try {
      this.s3.putObject(putObjectRequest);
    } catch (final AmazonServiceException e) {
      LOGGER.error(StringUtils.join("Cannot store S3 object at url '", s3Path, "'."), e);
      return false;
    }
    return true;
  }

  /**
   * Return false if an error occured
   *
   * @param amazonClient
   * @param bucketName
   * @return
   */
  private boolean createBucketIfNotExists(AmazonS3 amazonClient, final String bucketName) {
    try {
      if (!amazonClient.doesBucketExistV2(bucketName)) {
        amazonClient.createBucket(bucketName);
      }
      return true;
    } catch (final AmazonServiceException e) {
      LOGGER.debug(StringUtils.join("Cannot check existence or create a bucket with name '", bucketName, "'."), e);
    }
    return false;
  }

  private String buildS3Path(final RuleSpecification ruleSpec, final String ruleSpecId) {
    // path is: graphName/ruleType/targetRelations/ruleSpecId
    final StringBuilder pathBuilder = new StringBuilder();
    pathBuilder.append("https://s3-").append(getS3Region().getName()).append(".amazonaws.com/");
    pathBuilder.append(BUCKET_NAME);
    pathBuilder.append("/");
    if ((ruleSpec.getGraph() == null) || (ruleSpec.getGraph().getName() == null) || (ruleSpec.getType() == null)
        || (ruleSpec.getTargetRelation() == null) || ruleSpec.getTargetRelation().isEmpty()) {
      return null;
    }
    final NameEnum graphName = ruleSpec.getGraph().getName();
    // use the endpoint url if the graph is OTHER
    final String graphNameString = graphName == NameEnum.OTHER
        ? ruleSpec.getGraph().getEndpoint().replaceAll("[^A-Za-z0-9]", "_")
        : graphName.toString();
    pathBuilder.append(graphNameString).append("/");
    pathBuilder.append(ruleSpec.getType().toString()).append("/");
    pathBuilder.append(buildRelationSubpath(ruleSpec.getTargetRelation())).append("/");
    pathBuilder.append(ruleSpecId);
    pathBuilder.append(".").append(STORAGE_EXTENSION);
    return pathBuilder.toString();
  }

  private final String buildRelationSubpath(final List<String> relations) {
    final StringBuilder relationBuilder = new StringBuilder();
    relationBuilder.append(relations.get(0).replaceAll("[^A-Za-z0-9]", "_"));
    for (int i = 1; i < relations.size(); i++) {
      relationBuilder.append("-");
      relationBuilder.append(relations.get(i).replaceAll("[^A-Za-z0-9]", "_"));
    }
    return relationBuilder.toString();
  }

  private void initialiseS3Client() {
    if (this.s3 == null) {
      this.provider = getS3Provider();
      this.region = getS3Region();
      this.s3 = amazonS3FromRegion(region);
    }
  }

  private AWSCredentialsProvider getS3Provider() {
    final File f = new File(S3_CREDENTIALS_FILE);
    return new AWSCredentialsProviderChain(new EnvironmentVariableCredentialsProvider(),
        new PropertiesFileCredentialsProvider(f.toString()), new SystemPropertiesCredentialsProvider(),
        new EC2ContainerCredentialsProviderWrapper(), InstanceProfileCredentialsProvider.getInstance());
  }

  private Regions getS3Region() {
    return Regions.valueOf(S3_REGIONS);
  }

  private AmazonS3 amazonS3FromRegion(Regions region) {
    final AmazonS3ClientBuilder builder = AmazonS3ClientBuilder.standard().withRegion(region)
        .withCredentials(this.provider).withClientConfiguration(new ClientConfiguration().withMaxErrorRetry(3)
            .withConnectionTimeout(120 * 1000).withSocketTimeout(120 * 1000));
    s3 = builder.build();
    return s3;
  }

}
