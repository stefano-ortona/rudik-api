package asu.edu.api.model;

import java.util.Objects;
import asu.edu.api.model.KeyValuePair;
import asu.edu.api.model.RuleSpecification;
import asu.edu.api.model.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * RuleStatus
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class RuleStatus   {
  private RuleSpecification rule = null;

  private Status status = null;

  private List<KeyValuePair> metadata = new ArrayList<KeyValuePair>();

  public RuleStatus rule(RuleSpecification rule) {
    this.rule = rule;
    return this;
  }

   /**
   * Get rule
   * @return rule
  **/
  @ApiModelProperty(required = true, value = "")
  public RuleSpecification getRule() {
    return rule;
  }

  public void setRule(RuleSpecification rule) {
    this.rule = rule;
  }

  public RuleStatus status(Status status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")
  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public RuleStatus metadata(List<KeyValuePair> metadata) {
    this.metadata = metadata;
    return this;
  }

  public RuleStatus addMetadataItem(KeyValuePair metadataItem) {
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
    RuleStatus ruleStatus = (RuleStatus) o;
    return Objects.equals(this.rule, ruleStatus.rule) &&
        Objects.equals(this.status, ruleStatus.status) &&
        Objects.equals(this.metadata, ruleStatus.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rule, status, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RuleStatus {\n");
    
    sb.append("    rule: ").append(toIndentedString(rule)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

