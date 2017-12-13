package asu.edu.rule_miner.api.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.GenericType;

import asu.edu.rule_miner.api.model.RuleInstantiation;
import asu.edu.rule_miner.api.model.RuleResult;
import asu.edu.rule_miner.api.model.RuleSpecification;
import asu.edu.rule_miner.api.model.RuleStatus;
import asu.edu.rule_miner.api.service.ApiClient;
import asu.edu.rule_miner.api.service.ApiException;
import asu.edu.rule_miner.api.service.Configuration;
import asu.edu.rule_miner.api.service.Pair;
import jersey.repackaged.com.google.common.collect.Maps;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-24T18:17:08.173Z")
public class RuleApi {
  private ApiClient apiClient;

  public RuleApi() {
    this(Configuration.getDefaultApiClient());
  }

  public RuleApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Horn Rules Instantiation over the Graph
   * Instantiate the given rule over the graph to compute new generated facts in case of positive rules, or potential erroneous triples in case of negative rules.
   * @param ruleSpecification Specifies the input rule to be instantiated over the graph (required)
   * @return RuleInstantiation
   * @throws ApiException if fails to make API call
   */
  public RuleInstantiation instantiateRule(RuleResult ruleSpecification) throws ApiException {
    final Object localVarPostBody = ruleSpecification;

    // verify the required parameter 'ruleSpecification' is set
    if (ruleSpecification == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleSpecification' when calling instantiateRule");
    }

    // create path and map variables
    final String localVarPath = "/rule/instantiate".replaceAll("\\{format\\}", "json");

    // query params
    final List<Pair> localVarQueryParams = new ArrayList<Pair>();
    final Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    final Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    final String[] localVarAccepts = { "application/json" };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = { "application/json" };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    final String[] localVarAuthNames = new String[] {};

    final GenericType<RuleInstantiation> localVarReturnType = new GenericType<RuleInstantiation>() {
    };
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
        localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
  }

  /**
   * Horn Rules Mining
   * Triggers the induction of a set of logical rules for the given knowledge graph and a target predicate. The call is asynchronous, and the computed rules will be stored and they can be retrieved as soon as the mining is complete, returning a 202. If the requested rules with same parameters have been computed before, then the rules are immediately returned with a 200.
   * @param ruleSpecification Specifies the predicate and mining parameters for rule induction. (required)
   * @param forceMining If set to true, then the mining of the rules is always forced no matter whether whether the target rules have been computed before. (optional)
   * @return RuleResult or RuleStatus
   * @throws ApiException if fails to make API call
   */
  public Object mineRule(RuleSpecification ruleSpecification, Boolean forceMining) throws ApiException {
    final Object localVarPostBody = ruleSpecification;

    // verify the required parameter 'ruleSpecification' is set
    if (ruleSpecification == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleSpecification' when calling mineRule");
    }

    // create path and map variables
    final String localVarPath = "/rule/mine".replaceAll("\\{format\\}", "json");

    // query params
    final List<Pair> localVarQueryParams = new ArrayList<Pair>();
    final Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    final Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "forceMining", forceMining));

    final String[] localVarAccepts = { "application/json" };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = { "application/json" };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    final String[] localVarAuthNames = new String[] {};

    final Map<Integer, GenericType<?>> code2resultType = Maps.newHashMap();
    code2resultType.put(200, new GenericType<RuleResult>() {
    });
    code2resultType.put(202, new GenericType<RuleStatus>() {
    });

    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
        localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, code2resultType);
  }
}
