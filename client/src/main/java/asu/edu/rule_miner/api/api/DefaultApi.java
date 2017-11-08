package asu.edu.rule_miner.api.api;

import asu.edu.rule_miner.api.service.ApiException;
import asu.edu.rule_miner.api.service.ApiClient;
import asu.edu.rule_miner.api.service.Configuration;
import asu.edu.rule_miner.api.service.Pair;

import javax.ws.rs.core.GenericType;

import asu.edu.api.model.ErrorModel;
import asu.edu.api.model.APIStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-08T13:58:07.522Z")
public class DefaultApi {
  private ApiClient apiClient;

  public DefaultApi() {
    this(Configuration.getDefaultApiClient());
  }

  public DefaultApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Status of APIs
   * Retrieves the status of the APIs
   * @param full Return the curren status of the API. (optional)
   * @return APIStatus
   * @throws ApiException if fails to make API call
   */
  public APIStatus statusAPI(Boolean full) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/_status".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "full", full));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<APIStatus> localVarReturnType = new GenericType<APIStatus>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
