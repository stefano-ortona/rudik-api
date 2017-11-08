# DefaultApi

All URIs are relative to *http://localhost:8100/v1/apis/rudik*

Method | HTTP request | Description
------------- | ------------- | -------------
[**statusAPI**](DefaultApi.md#statusAPI) | **GET** /_status | Status of APIs


<a name="statusAPI"></a>
# **statusAPI**
> APIStatus statusAPI(full)

Status of APIs

Retrieves the status of the APIs

### Example
```java
// Import classes:
//import asu.edu.rule_miner.api.service.ApiException;
//import asu.edu.rule_miner.api.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
Boolean full = true; // Boolean | Return the curren status of the API.
try {
    APIStatus result = apiInstance.statusAPI(full);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#statusAPI");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **full** | **Boolean**| Return the curren status of the API. | [optional]

### Return type

[**APIStatus**](APIStatus.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

