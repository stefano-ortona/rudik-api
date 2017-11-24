
# GraphSpecification

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | ID for the current graph. Derived from properties of the current mining configuration and graph name. Currently &lt;hash(GraphSpecification)&gt; |  [optional]
**name** | [**NameEnum**](#NameEnum) | Name of the knowledge graph to mine rules from. If chosen from known graphs, the mining will happen on the stored graphs. If &#39;other&#39; is chosen, then an endpoint url must be provided to query the graph. | 
**endpoint** | **String** | Sparql endpoint to query the give knowledge graph. |  [optional]
**iri** | **String** | Graph iri. |  [optional]
**prefix** | [**List&lt;RelationPrefix&gt;**](RelationPrefix.md) | RDF prefixes to be specified when running SPARQL queries. |  [optional]
**targetPrefix** | **List&lt;String&gt;** | If specified, all relations used in the mining must start with one of these prefixes. |  [optional]
**avoidRelation** | **List&lt;String&gt;** | Relations to avoid during the mining. |  [optional]
**typePrefix** | **String** | Relation to be used as type-relation when discovering types for entities. |  [optional]
**disequalityRelation** | **Integer** | Specify here the number of type-relations two entities must have in common to be considered of the same type. 0 means all types, while a negative number means two entities will be never considered of the same type. |  [optional]
**alpha** | **Double** | Adjust alph to get more rules in output with less accuracy. Alpha can be between 0 and 1, and alpha+beta&#x3D;1. |  [optional]
**beta** | **Double** | Adjust beta to get less rules in output with higher accuracy. Beta can be between 0 and 1, and alpha+beta&#x3D;1. |  [optional]
**incomingEdges** | **Integer** | Set the maximum number of incoming edges for an entity during the mining exploration. |  [optional]
**outgoingEdges** | **Integer** | Set the maximum number of outgoing edges for an entity during the mining exploration. |  [optional]
**positiveExamplesLimit** | **Integer** | Set the limit for the maximum number of positive examples. |  [optional]
**negativeExamplesLimit** | **Integer** | Set the limit for the maximum number of negative examples. |  [optional]
**literal** | **Boolean** | Include(true)/exclude(false) literal values from the mining. |  [optional]
**genericType** | **List&lt;String&gt;** | Generic abstract type to avoid when computing subject and object most common types for a given target predicate. |  [optional]


<a name="NameEnum"></a>
## Enum: NameEnum
Name | Value
---- | -----
YAGO | &quot;yago&quot;
DBPEDIA | &quot;dbpedia&quot;
WIKIMETA | &quot;wikimeta&quot;
FREEBASE | &quot;freebase&quot;
OTHER | &quot;other&quot;



