package asu.edu.rule_miner.api.model;

import java.util.Objects;
import asu.edu.rule_miner.api.model.KeyValuePair;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * APIStatus
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T17:54:27.167Z")
public class APIStatus   {
  private String status = null;

  private String description = null;

  private List<KeyValuePair> metadata = new ArrayList<KeyValuePair>();

  public APIStatus status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Status code for the API
   * @return status
  **/
  @ApiModelProperty(value = "Status code for the API")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public APIStatus description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Textual description of the status
   * @return description
  **/
  @ApiModelProperty(value = "Textual description of the status")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public APIStatus metadata(List<KeyValuePair> metadata) {
    this.metadata = metadata;
    return this;
  }

  public APIStatus addMetadataItem(KeyValuePair metadataItem) {
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
    APIStatus aPIStatus = (APIStatus) o;
    return Objects.equals(this.status, aPIStatus.status) &&
        Objects.equals(this.description, aPIStatus.description) &&
        Objects.equals(this.metadata, aPIStatus.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, description, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class APIStatus {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

