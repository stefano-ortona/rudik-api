
# RuleResult

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | ID of the rule result. Currently same one used for the RuleSpecification+TimeStamp of retrieval. | 
**specification** | [**RuleSpecification**](RuleSpecification.md) |  | 
**statistics** | [**RuleStatistics**](RuleStatistics.md) |  |  [optional]
**rule** | [**List&lt;HornRule&gt;**](HornRule.md) | Output logical body rules produced by RuDiK including their statistics. | 
**metadata** | [**List&lt;KeyValuePair&gt;**](KeyValuePair.md) | Metadata includes things like the time of creation, the version of the induction system, … |  [optional]



