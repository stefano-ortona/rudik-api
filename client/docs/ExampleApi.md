# ExampleApi

All URIs are relative to *http://localhost:8100/v1/apis/rudik*

Method | HTTP request | Description
------------- | ------------- | -------------
[**exampleGeneration**](ExampleApi.md#exampleGeneration) | **POST** /example/generation | Positive and Negative Example Generation
[**exampleType**](ExampleApi.md#exampleType) | **POST** /example/type | Most Common Type Example Generation


<a name="exampleGeneration"></a>
# **exampleGeneration**
> RuleExample exampleGeneration(predicateSpecification)

Positive and Negative Example Generation

Generate positive and negative examples for the given target predicate. If types of subject and/or object are not specified, then the most common ones from the graph will be used.

### Example
```java
// Import classes:
//import asu.edu.rule_miner.api.service.ApiException;
//import asu.edu.rule_miner.api.api.ExampleApi;


ExampleApi apiInstance = new ExampleApi();
RuleSpecification predicateSpecification = new RuleSpecification(); // RuleSpecification | Specifies the input target predicate for which positive and negative examples will be generated.
try {
    RuleExample result = apiInstance.exampleGeneration(predicateSpecification);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExampleApi#exampleGeneration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **predicateSpecification** | [**RuleSpecification**](RuleSpecification.md)| Specifies the input target predicate for which positive and negative examples will be generated. |

### Return type

[**RuleExample**](RuleExample.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="exampleType"></a>
# **exampleType**
> EntityPair exampleType(predicateSpecification)

Most Common Type Example Generation

Generate most common types for subject and object examples for the given input target predicate according to the graph.

### Example
```java
// Import classes:
//import asu.edu.rule_miner.api.service.ApiException;
//import asu.edu.rule_miner.api.api.ExampleApi;


ExampleApi apiInstance = new ExampleApi();
RuleSpecification predicateSpecification = new RuleSpecification(); // RuleSpecification | Specifies the input target predicate for which most common types for subject and object will be generated.
try {
    EntityPair result = apiInstance.exampleType(predicateSpecification);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExampleApi#exampleType");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **predicateSpecification** | [**RuleSpecification**](RuleSpecification.md)| Specifies the input target predicate for which most common types for subject and object will be generated. |

### Return type

[**EntityPair**](EntityPair.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

