package asu.edu.rule_miner.api.api;

import asu.edu.rule_miner.api.service.ApiException;
import asu.edu.rule_miner.api.service.ApiClient;
import asu.edu.rule_miner.api.service.Configuration;
import asu.edu.rule_miner.api.service.Pair;

import javax.ws.rs.core.GenericType;

import asu.edu.api.model.RuleInstantiation;
import asu.edu.api.model.ErrorModel;
import asu.edu.api.model.RuleResult;
import asu.edu.api.model.RuleSpecification;
import asu.edu.api.model.RuleStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-08T13:58:07.522Z")
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
    Object localVarPostBody = ruleSpecification;
    
    // verify the required parameter 'ruleSpecification' is set
    if (ruleSpecification == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleSpecification' when calling instantiateRule");
    }
    
    // create path and map variables
    String localVarPath = "/rule/instantiate".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<RuleInstantiation> localVarReturnType = new GenericType<RuleInstantiation>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Horn Rules Mining
   * Triggers the induction of a set of logical rules for the given knwoledge graph and a target predicate. The call is asynchronous, and the computed rules will be stored and they can be retrieved as soon as the mining is complete.
   * @param ruleSpecification Specifies the predicate and mining parametets for rule induction. (required)
   * @return RuleResult
   * @throws ApiException if fails to make API call
   */
  public RuleResult mineRule(RuleSpecification ruleSpecification) throws ApiException {
    Object localVarPostBody = ruleSpecification;
    
    // verify the required parameter 'ruleSpecification' is set
    if (ruleSpecification == null) {
      throw new ApiException(400, "Missing the required parameter 'ruleSpecification' when calling mineRule");
    }
    
    // create path and map variables
    String localVarPath = "/rule/mine".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<RuleResult> localVarReturnType = new GenericType<RuleResult>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
