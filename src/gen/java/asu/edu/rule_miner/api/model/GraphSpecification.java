package asu.edu.rule_miner.api.model;

import java.util.Objects;
import asu.edu.rule_miner.api.model.RelationPrefix;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * GraphSpecification
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T17:54:27.167Z")
public class GraphSpecification   {
  private String id = null;

  /**
   * Name of the knowledge graph to mine rules from. If chosen from known graphs, the mining will happen on the stored graphs. If 'other' is chosen, then an endpoint url must be provided to query the graph.
   */
  public enum NameEnum {
    YAGO("yago"),
    
    DBPEDIA("dbpedia"),
    
    WIKIMETA("wikimeta"),
    
    FREEBASE("freebase"),
    
    OTHER("other");

    private String value;

    NameEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private NameEnum name = null;

  private String endpoint = null;

  private String iri = null;

  private List<RelationPrefix> prefix = new ArrayList<RelationPrefix>();

  private List<String> targetPrefix = new ArrayList<String>();

  private List<String> avoidRelation = new ArrayList<String>();

  private String typePrefix = null;

  private Integer disequalityRelation = null;

  private Double alpha = null;

  private Double beta = null;

  private Integer incomingEdges = null;

  private Integer outgoingEdges = null;

  private Integer positiveExamplesLimit = null;

  private Integer negativeExamplesLimit = null;

  private Boolean literal = null;

  private List<String> genericType = new ArrayList<String>();

  public GraphSpecification id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ID for the current graph. Derived from properties of the current mining configuration and graph name. Currently <hash(GraphSpecification)>
   * @return id
  **/
  @ApiModelProperty(value = "ID for the current graph. Derived from properties of the current mining configuration and graph name. Currently <hash(GraphSpecification)>")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GraphSpecification name(NameEnum name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the knowledge graph to mine rules from. If chosen from known graphs, the mining will happen on the stored graphs. If 'other' is chosen, then an endpoint url must be provided to query the graph.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the knowledge graph to mine rules from. If chosen from known graphs, the mining will happen on the stored graphs. If 'other' is chosen, then an endpoint url must be provided to query the graph.")
  public NameEnum getName() {
    return name;
  }

  public void setName(NameEnum name) {
    this.name = name;
  }

  public GraphSpecification endpoint(String endpoint) {
    this.endpoint = endpoint;
    return this;
  }

   /**
   * Sparql endpoint to query the give knowledge graph.
   * @return endpoint
  **/
  @ApiModelProperty(value = "Sparql endpoint to query the give knowledge graph.")
  public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  public GraphSpecification iri(String iri) {
    this.iri = iri;
    return this;
  }

   /**
   * Graph iri.
   * @return iri
  **/
  @ApiModelProperty(value = "Graph iri.")
  public String getIri() {
    return iri;
  }

  public void setIri(String iri) {
    this.iri = iri;
  }

  public GraphSpecification prefix(List<RelationPrefix> prefix) {
    this.prefix = prefix;
    return this;
  }

  public GraphSpecification addPrefixItem(RelationPrefix prefixItem) {
    this.prefix.add(prefixItem);
    return this;
  }

   /**
   * RDF prefixes to be specified when running SPARQL queries.
   * @return prefix
  **/
  @ApiModelProperty(value = "RDF prefixes to be specified when running SPARQL queries.")
  public List<RelationPrefix> getPrefix() {
    return prefix;
  }

  public void setPrefix(List<RelationPrefix> prefix) {
    this.prefix = prefix;
  }

  public GraphSpecification targetPrefix(List<String> targetPrefix) {
    this.targetPrefix = targetPrefix;
    return this;
  }

  public GraphSpecification addTargetPrefixItem(String targetPrefixItem) {
    this.targetPrefix.add(targetPrefixItem);
    return this;
  }

   /**
   * If specified, all relations used in the mining must start with one of these prefixes.
   * @return targetPrefix
  **/
  @ApiModelProperty(value = "If specified, all relations used in the mining must start with one of these prefixes.")
  public List<String> getTargetPrefix() {
    return targetPrefix;
  }

  public void setTargetPrefix(List<String> targetPrefix) {
    this.targetPrefix = targetPrefix;
  }

  public GraphSpecification avoidRelation(List<String> avoidRelation) {
    this.avoidRelation = avoidRelation;
    return this;
  }

  public GraphSpecification addAvoidRelationItem(String avoidRelationItem) {
    this.avoidRelation.add(avoidRelationItem);
    return this;
  }

   /**
   * Relations to avoid during the mining.
   * @return avoidRelation
  **/
  @ApiModelProperty(value = "Relations to avoid during the mining.")
  public List<String> getAvoidRelation() {
    return avoidRelation;
  }

  public void setAvoidRelation(List<String> avoidRelation) {
    this.avoidRelation = avoidRelation;
  }

  public GraphSpecification typePrefix(String typePrefix) {
    this.typePrefix = typePrefix;
    return this;
  }

   /**
   * Relation to be used as type-relation when discovering types for entities.
   * @return typePrefix
  **/
  @ApiModelProperty(value = "Relation to be used as type-relation when discovering types for entities.")
  public String getTypePrefix() {
    return typePrefix;
  }

  public void setTypePrefix(String typePrefix) {
    this.typePrefix = typePrefix;
  }

  public GraphSpecification disequalityRelation(Integer disequalityRelation) {
    this.disequalityRelation = disequalityRelation;
    return this;
  }

   /**
   * Specify here the number of type-relations two entities must have in common to be considered of the same type. 0 means all types, while a negative number means two entities will be never considered of the same type.
   * @return disequalityRelation
  **/
  @ApiModelProperty(value = "Specify here the number of type-relations two entities must have in common to be considered of the same type. 0 means all types, while a negative number means two entities will be never considered of the same type.")
  public Integer getDisequalityRelation() {
    return disequalityRelation;
  }

  public void setDisequalityRelation(Integer disequalityRelation) {
    this.disequalityRelation = disequalityRelation;
  }

  public GraphSpecification alpha(Double alpha) {
    this.alpha = alpha;
    return this;
  }

   /**
   * Adjust alph to get more rules in output with less accuracy. Alpha can be between 0 and 1, and alpha+beta=1.
   * @return alpha
  **/
  @ApiModelProperty(value = "Adjust alph to get more rules in output with less accuracy. Alpha can be between 0 and 1, and alpha+beta=1.")
  public Double getAlpha() {
    return alpha;
  }

  public void setAlpha(Double alpha) {
    this.alpha = alpha;
  }

  public GraphSpecification beta(Double beta) {
    this.beta = beta;
    return this;
  }

   /**
   * Adjust beta to get less rules in output with higher accuracy. Beta can be between 0 and 1, and alpha+beta=1.
   * @return beta
  **/
  @ApiModelProperty(value = "Adjust beta to get less rules in output with higher accuracy. Beta can be between 0 and 1, and alpha+beta=1.")
  public Double getBeta() {
    return beta;
  }

  public void setBeta(Double beta) {
    this.beta = beta;
  }

  public GraphSpecification incomingEdges(Integer incomingEdges) {
    this.incomingEdges = incomingEdges;
    return this;
  }

   /**
   * Set the maximum number of incoming edges for an entity during the mining exploration.
   * @return incomingEdges
  **/
  @ApiModelProperty(value = "Set the maximum number of incoming edges for an entity during the mining exploration.")
  public Integer getIncomingEdges() {
    return incomingEdges;
  }

  public void setIncomingEdges(Integer incomingEdges) {
    this.incomingEdges = incomingEdges;
  }

  public GraphSpecification outgoingEdges(Integer outgoingEdges) {
    this.outgoingEdges = outgoingEdges;
    return this;
  }

   /**
   * Set the maximum number of outgoing edges for an entity during the mining exploration.
   * @return outgoingEdges
  **/
  @ApiModelProperty(value = "Set the maximum number of outgoing edges for an entity during the mining exploration.")
  public Integer getOutgoingEdges() {
    return outgoingEdges;
  }

  public void setOutgoingEdges(Integer outgoingEdges) {
    this.outgoingEdges = outgoingEdges;
  }

  public GraphSpecification positiveExamplesLimit(Integer positiveExamplesLimit) {
    this.positiveExamplesLimit = positiveExamplesLimit;
    return this;
  }

   /**
   * Set the limit for the maximum number of positive examples.
   * @return positiveExamplesLimit
  **/
  @ApiModelProperty(value = "Set the limit for the maximum number of positive examples.")
  public Integer getPositiveExamplesLimit() {
    return positiveExamplesLimit;
  }

  public void setPositiveExamplesLimit(Integer positiveExamplesLimit) {
    this.positiveExamplesLimit = positiveExamplesLimit;
  }

  public GraphSpecification negativeExamplesLimit(Integer negativeExamplesLimit) {
    this.negativeExamplesLimit = negativeExamplesLimit;
    return this;
  }

   /**
   * Set the limit for the maximum number of negative examples.
   * @return negativeExamplesLimit
  **/
  @ApiModelProperty(value = "Set the limit for the maximum number of negative examples.")
  public Integer getNegativeExamplesLimit() {
    return negativeExamplesLimit;
  }

  public void setNegativeExamplesLimit(Integer negativeExamplesLimit) {
    this.negativeExamplesLimit = negativeExamplesLimit;
  }

  public GraphSpecification literal(Boolean literal) {
    this.literal = literal;
    return this;
  }

   /**
   * Include(true)/exclude(false) literal values from the mining.
   * @return literal
  **/
  @ApiModelProperty(value = "Include(true)/exclude(false) literal values from the mining.")
  public Boolean getLiteral() {
    return literal;
  }

  public void setLiteral(Boolean literal) {
    this.literal = literal;
  }

  public GraphSpecification genericType(List<String> genericType) {
    this.genericType = genericType;
    return this;
  }

  public GraphSpecification addGenericTypeItem(String genericTypeItem) {
    this.genericType.add(genericTypeItem);
    return this;
  }

   /**
   * Generic abstract type to avoid when computing subject and object most common types for a given target predicate.
   * @return genericType
  **/
  @ApiModelProperty(value = "Generic abstract type to avoid when computing subject and object most common types for a given target predicate.")
  public List<String> getGenericType() {
    return genericType;
  }

  public void setGenericType(List<String> genericType) {
    this.genericType = genericType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GraphSpecification graphSpecification = (GraphSpecification) o;
    return Objects.equals(this.id, graphSpecification.id) &&
        Objects.equals(this.name, graphSpecification.name) &&
        Objects.equals(this.endpoint, graphSpecification.endpoint) &&
        Objects.equals(this.iri, graphSpecification.iri) &&
        Objects.equals(this.prefix, graphSpecification.prefix) &&
        Objects.equals(this.targetPrefix, graphSpecification.targetPrefix) &&
        Objects.equals(this.avoidRelation, graphSpecification.avoidRelation) &&
        Objects.equals(this.typePrefix, graphSpecification.typePrefix) &&
        Objects.equals(this.disequalityRelation, graphSpecification.disequalityRelation) &&
        Objects.equals(this.alpha, graphSpecification.alpha) &&
        Objects.equals(this.beta, graphSpecification.beta) &&
        Objects.equals(this.incomingEdges, graphSpecification.incomingEdges) &&
        Objects.equals(this.outgoingEdges, graphSpecification.outgoingEdges) &&
        Objects.equals(this.positiveExamplesLimit, graphSpecification.positiveExamplesLimit) &&
        Objects.equals(this.negativeExamplesLimit, graphSpecification.negativeExamplesLimit) &&
        Objects.equals(this.literal, graphSpecification.literal) &&
        Objects.equals(this.genericType, graphSpecification.genericType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, endpoint, iri, prefix, targetPrefix, avoidRelation, typePrefix, disequalityRelation, alpha, beta, incomingEdges, outgoingEdges, positiveExamplesLimit, negativeExamplesLimit, literal, genericType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GraphSpecification {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    endpoint: ").append(toIndentedString(endpoint)).append("\n");
    sb.append("    iri: ").append(toIndentedString(iri)).append("\n");
    sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
    sb.append("    targetPrefix: ").append(toIndentedString(targetPrefix)).append("\n");
    sb.append("    avoidRelation: ").append(toIndentedString(avoidRelation)).append("\n");
    sb.append("    typePrefix: ").append(toIndentedString(typePrefix)).append("\n");
    sb.append("    disequalityRelation: ").append(toIndentedString(disequalityRelation)).append("\n");
    sb.append("    alpha: ").append(toIndentedString(alpha)).append("\n");
    sb.append("    beta: ").append(toIndentedString(beta)).append("\n");
    sb.append("    incomingEdges: ").append(toIndentedString(incomingEdges)).append("\n");
    sb.append("    outgoingEdges: ").append(toIndentedString(outgoingEdges)).append("\n");
    sb.append("    positiveExamplesLimit: ").append(toIndentedString(positiveExamplesLimit)).append("\n");
    sb.append("    negativeExamplesLimit: ").append(toIndentedString(negativeExamplesLimit)).append("\n");
    sb.append("    literal: ").append(toIndentedString(literal)).append("\n");
    sb.append("    genericType: ").append(toIndentedString(genericType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

