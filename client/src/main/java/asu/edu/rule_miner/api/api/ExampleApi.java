package asu.edu.rule_miner.api.api;

import asu.edu.rule_miner.api.service.ApiException;
import asu.edu.rule_miner.api.service.ApiClient;
import asu.edu.rule_miner.api.service.Configuration;
import asu.edu.rule_miner.api.service.Pair;

import javax.ws.rs.core.GenericType;

import asu.edu.api.model.ErrorModel;
import asu.edu.api.model.RuleSpecification;
import asu.edu.api.model.RuleExample;
import asu.edu.api.model.EntityPair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-08T13:58:07.522Z")
public class ExampleApi {
  private ApiClient apiClient;

  public ExampleApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ExampleApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Positive and Negative Example Generation
   * Generate positive and negative examples for the given target predicate. If types of subject and/or object are not specified, then the most common ones from the graph will be used.
   * @param predicateSpecification Specifies the input target predicate for which positive and negative examples will be generated. (required)
   * @return RuleExample
   * @throws ApiException if fails to make API call
   */
  public RuleExample exampleGeneration(RuleSpecification predicateSpecification) throws ApiException {
    Object localVarPostBody = predicateSpecification;
    
    // verify the required parameter 'predicateSpecification' is set
    if (predicateSpecification == null) {
      throw new ApiException(400, "Missing the required parameter 'predicateSpecification' when calling exampleGeneration");
    }
    
    // create path and map variables
    String localVarPath = "/example/generation".replaceAll("\\{format\\}","json");

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

    GenericType<RuleExample> localVarReturnType = new GenericType<RuleExample>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Most Common Type Example Generation
   * Generate most common types for subject and object examples for the given input target predicate according to the graph.
   * @param predicateSpecification Specifies the input target predicate for which most common types for subject and object will be generated. (required)
   * @return EntityPair
   * @throws ApiException if fails to make API call
   */
  public EntityPair exampleType(RuleSpecification predicateSpecification) throws ApiException {
    Object localVarPostBody = predicateSpecification;
    
    // verify the required parameter 'predicateSpecification' is set
    if (predicateSpecification == null) {
      throw new ApiException(400, "Missing the required parameter 'predicateSpecification' when calling exampleType");
    }
    
    // create path and map variables
    String localVarPath = "/example/type".replaceAll("\\{format\\}","json");

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

    GenericType<EntityPair> localVarReturnType = new GenericType<EntityPair>() {};
    return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
