package asu.edu.api.model;

import java.util.Objects;
import asu.edu.api.model.EntityPair;
import asu.edu.api.model.GraphSpecification;
import asu.edu.api.model.KeyValuePair;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * RuleSpecification
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class RuleSpecification   {
  private String id = null;

  private List<String> targetRelation = new ArrayList<String>();

  /**
   * Decide to mine positive or negative rule for the target predicates.
   */
  public enum TypeEnum {
    POSITIVE("positive"),
    
    NEGATIVE("negative");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private TypeEnum type = null;

  private GraphSpecification graph = null;

  private Integer maxLength = null;

  private String subjectType = null;

  private String objectType = null;

  private List<EntityPair> positiveExamples = new ArrayList<EntityPair>();

  private List<EntityPair> negativeExamples = new ArrayList<EntityPair>();

  private String resultEndpoint = null;

  private List<KeyValuePair> metadata = new ArrayList<KeyValuePair>();

  public RuleSpecification id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ID for the target predicate on the current graph. Derived from the target predicates, the type mining and the current graph. Currently <hash(RuleSpecification)+hash(GraphSpecification)>
   * @return id
  **/
  @ApiModelProperty(value = "ID for the target predicate on the current graph. Derived from the target predicates, the type mining and the current graph. Currently <hash(RuleSpecification)+hash(GraphSpecification)>")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RuleSpecification targetRelation(List<String> targetRelation) {
    this.targetRelation = targetRelation;
    return this;
  }

  public RuleSpecification addTargetRelationItem(String targetRelationItem) {
    this.targetRelation.add(targetRelationItem);
    return this;
  }

   /**
   * URLs from which to start the crawling of the site, usually section pages.
   * @return targetRelation
  **/
  @ApiModelProperty(required = true, value = "URLs from which to start the crawling of the site, usually section pages.")
  public List<String> getTargetRelation() {
    return targetRelation;
  }

  public void setTargetRelation(List<String> targetRelation) {
    this.targetRelation = targetRelation;
  }

  public RuleSpecification type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Decide to mine positive or negative rule for the target predicates.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "Decide to mine positive or negative rule for the target predicates.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public RuleSpecification graph(GraphSpecification graph) {
    this.graph = graph;
    return this;
  }

   /**
   * Get graph
   * @return graph
  **/
  @ApiModelProperty(required = true, value = "")
  public GraphSpecification getGraph() {
    return graph;
  }

  public void setGraph(GraphSpecification graph) {
    this.graph = graph;
  }

  public RuleSpecification maxLength(Integer maxLength) {
    this.maxLength = maxLength;
    return this;
  }

   /**
   * Maximum number of atoms in the body of the rule.
   * @return maxLength
  **/
  @ApiModelProperty(value = "Maximum number of atoms in the body of the rule.")
  public Integer getMaxLength() {
    return maxLength;
  }

  public void setMaxLength(Integer maxLength) {
    this.maxLength = maxLength;
  }

  public RuleSpecification subjectType(String subjectType) {
    this.subjectType = subjectType;
    return this;
  }

   /**
   * Graph type of the subject entity of the head of the rule. If not specified, the most common one from the graph will be used.
   * @return subjectType
  **/
  @ApiModelProperty(value = "Graph type of the subject entity of the head of the rule. If not specified, the most common one from the graph will be used.")
  public String getSubjectType() {
    return subjectType;
  }

  public void setSubjectType(String subjectType) {
    this.subjectType = subjectType;
  }

  public RuleSpecification objectType(String objectType) {
    this.objectType = objectType;
    return this;
  }

   /**
   * Graph type of the object entity of the head of the rule. If not specified, the most common one from the graph will be used.
   * @return objectType
  **/
  @ApiModelProperty(value = "Graph type of the object entity of the head of the rule. If not specified, the most common one from the graph will be used.")
  public String getObjectType() {
    return objectType;
  }

  public void setObjectType(String objectType) {
    this.objectType = objectType;
  }

  public RuleSpecification positiveExamples(List<EntityPair> positiveExamples) {
    this.positiveExamples = positiveExamples;
    return this;
  }

  public RuleSpecification addPositiveExamplesItem(EntityPair positiveExamplesItem) {
    this.positiveExamples.add(positiveExamplesItem);
    return this;
  }

   /**
   * Positive example pairs used for induction. If not provided, they will be computed from the graph using custom heuristics.
   * @return positiveExamples
  **/
  @ApiModelProperty(value = "Positive example pairs used for induction. If not provided, they will be computed from the graph using custom heuristics.")
  public List<EntityPair> getPositiveExamples() {
    return positiveExamples;
  }

  public void setPositiveExamples(List<EntityPair> positiveExamples) {
    this.positiveExamples = positiveExamples;
  }

  public RuleSpecification negativeExamples(List<EntityPair> negativeExamples) {
    this.negativeExamples = negativeExamples;
    return this;
  }

  public RuleSpecification addNegativeExamplesItem(EntityPair negativeExamplesItem) {
    this.negativeExamples.add(negativeExamplesItem);
    return this;
  }

   /**
   * Negative example pairs used for induction. If not provided, they will be computed from the graph using custom heuristics.
   * @return negativeExamples
  **/
  @ApiModelProperty(value = "Negative example pairs used for induction. If not provided, they will be computed from the graph using custom heuristics.")
  public List<EntityPair> getNegativeExamples() {
    return negativeExamples;
  }

  public void setNegativeExamples(List<EntityPair> negativeExamples) {
    this.negativeExamples = negativeExamples;
  }

  public RuleSpecification resultEndpoint(String resultEndpoint) {
    this.resultEndpoint = resultEndpoint;
    return this;
  }

   /**
   * URL where the information about this specific mined rules can be retrieved from.
   * @return resultEndpoint
  **/
  @ApiModelProperty(value = "URL where the information about this specific mined rules can be retrieved from.")
  public String getResultEndpoint() {
    return resultEndpoint;
  }

  public void setResultEndpoint(String resultEndpoint) {
    this.resultEndpoint = resultEndpoint;
  }

  public RuleSpecification metadata(List<KeyValuePair> metadata) {
    this.metadata = metadata;
    return this;
  }

  public RuleSpecification addMetadataItem(KeyValuePair metadataItem) {
    this.metadata.add(metadataItem);
    return this;
  }

   /**
   * Metadata includes things like the time of creation, the version of the induction system, …
   * @return metadata
  **/
  @ApiModelProperty(value = "Metadata includes things like the time of creation, the version of the induction system, …")
  public List<KeyValuePair> getMetadata() {
    return metadata;
  }

  public void setMetadata(List<KeyValuePair> metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RuleSpecification ruleSpecification = (RuleSpecification) o;
    return Objects.equals(this.id, ruleSpecification.id) &&
        Objects.equals(this.targetRelation, ruleSpecification.targetRelation) &&
        Objects.equals(this.type, ruleSpecification.type) &&
        Objects.equals(this.graph, ruleSpecification.graph) &&
        Objects.equals(this.maxLength, ruleSpecification.maxLength) &&
        Objects.equals(this.subjectType, ruleSpecification.subjectType) &&
        Objects.equals(this.objectType, ruleSpecification.objectType) &&
        Objects.equals(this.positiveExamples, ruleSpecification.positiveExamples) &&
        Objects.equals(this.negativeExamples, ruleSpecification.negativeExamples) &&
        Objects.equals(this.resultEndpoint, ruleSpecification.resultEndpoint) &&
        Objects.equals(this.metadata, ruleSpecification.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, targetRelation, type, graph, maxLength, subjectType, objectType, positiveExamples, negativeExamples, resultEndpoint, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RuleSpecification {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    targetRelation: ").append(toIndentedString(targetRelation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    graph: ").append(toIndentedString(graph)).append("\n");
    sb.append("    maxLength: ").append(toIndentedString(maxLength)).append("\n");
    sb.append("    subjectType: ").append(toIndentedString(subjectType)).append("\n");
    sb.append("    objectType: ").append(toIndentedString(objectType)).append("\n");
    sb.append("    positiveExamples: ").append(toIndentedString(positiveExamples)).append("\n");
    sb.append("    negativeExamples: ").append(toIndentedString(negativeExamples)).append("\n");
    sb.append("    resultEndpoint: ").append(toIndentedString(resultEndpoint)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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

