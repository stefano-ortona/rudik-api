
# RuleSpecification

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | ID for the target predicate on the current graph. Derived from the target predicates, the type mining and the current graph. Currently &lt;hash(RuleSpecification)+hash(GraphSpecification)&gt; |  [optional]
**targetRelation** | **List&lt;String&gt;** | URLs from which to start the crawling of the site, usually section pages. | 
**type** | [**TypeEnum**](#TypeEnum) | Decide to mine positive or negative rule for the target predicates. | 
**graph** | [**GraphSpecification**](GraphSpecification.md) |  | 
**maxLength** | **Integer** | Maximum number of atoms in the body of the rule. |  [optional]
**subjectType** | **String** | Graph type of the subject entity of the head of the rule. If not specified, the most common one from the graph will be used. |  [optional]
**objectType** | **String** | Graph type of the object entity of the head of the rule. If not specified, the most common one from the graph will be used. |  [optional]
**positiveExamples** | [**List&lt;EntityPair&gt;**](EntityPair.md) | Positive example pairs used for induction. If not provided, they will be computed from the graph using custom heuristics. |  [optional]
**negativeExamples** | [**List&lt;EntityPair&gt;**](EntityPair.md) | Negative example pairs used for induction. If not provided, they will be computed from the graph using custom heuristics. |  [optional]
**resultEndpoint** | **String** | URL where the information about this specific mined rules can be retrieved from. |  [optional]
**metadata** | [**List&lt;KeyValuePair&gt;**](KeyValuePair.md) | Metadata includes things like the time of creation, the version of the induction system, … |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
POSITIVE | &quot;positive&quot;
NEGATIVE | &quot;negative&quot;


