# RuleApi

All URIs are relative to *http://localhost:8100/v1/apis/rudik*

Method | HTTP request | Description
------------- | ------------- | -------------
[**instantiateRule**](RuleApi.md#instantiateRule) | **POST** /rule/instantiate | Horn Rules Instantiation over the Graph
[**mineRule**](RuleApi.md#mineRule) | **POST** /rule/mine | Horn Rules Mining


<a name="instantiateRule"></a>
# **instantiateRule**
> RuleInstantiation instantiateRule(ruleSpecification)

Horn Rules Instantiation over the Graph

Instantiate the given rule over the graph to compute new generated facts in case of positive rules, or potential erroneous triples in case of negative rules.

### Example
```java
// Import classes:
//import asu.edu.rule_miner.api.service.ApiException;
//import asu.edu.rule_miner.api.api.RuleApi;


RuleApi apiInstance = new RuleApi();
RuleResult ruleSpecification = new RuleResult(); // RuleResult | Specifies the input rule to be instantiated over the graph
try {
    RuleInstantiation result = apiInstance.instantiateRule(ruleSpecification);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleApi#instantiateRule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ruleSpecification** | [**RuleResult**](RuleResult.md)| Specifies the input rule to be instantiated over the graph |

### Return type

[**RuleInstantiation**](RuleInstantiation.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="mineRule"></a>
# **mineRule**
> RuleResult mineRule(ruleSpecification, forceMining)

Horn Rules Mining

Triggers the induction of a set of logical rules for the given knowledge graph and a target predicate. The call is asynchronous, and the computed rules will be stored and they can be retrieved as soon as the mining is complete, returning a 202. If the requested rules with same parameters have been computed before, then the rules are immediately returned with a 200.

### Example
```java
// Import classes:
//import asu.edu.rule_miner.api.service.ApiException;
//import asu.edu.rule_miner.api.api.RuleApi;


RuleApi apiInstance = new RuleApi();
RuleSpecification ruleSpecification = new RuleSpecification(); // RuleSpecification | Specifies the predicate and mining parameters for rule induction.
Boolean forceMining = true; // Boolean | If set to true, then the mining of the rules is always forced no matter whether whether the target rules have been computed before.
try {
    RuleResult result = apiInstance.mineRule(ruleSpecification, forceMining);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RuleApi#mineRule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **ruleSpecification** | [**RuleSpecification**](RuleSpecification.md)| Specifies the predicate and mining parameters for rule induction. |
 **forceMining** | **Boolean**| If set to true, then the mining of the rules is always forced no matter whether whether the target rules have been computed before. | [optional]

### Return type

[**RuleResult**](RuleResult.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

