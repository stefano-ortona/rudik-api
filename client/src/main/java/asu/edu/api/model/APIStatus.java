/**
 * RuDiK 1.0 Async APIs
 * Collection of APIs for inducing declarative rules with RuDiK and few others utility methods for RDF knowledge graphs accesible via a SPARQL endpoint.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: stefano.ortona@meltwater.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package asu.edu.api.model;

import java.util.Objects;
import asu.edu.api.model.KeyValuePair;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;


/**
 * APIStatus
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-08T13:58:07.522Z")
public class APIStatus   {
  @JsonProperty("status")
  private String status = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("metadata")
  private List<KeyValuePair> metadata = new ArrayList<KeyValuePair>();

  public APIStatus status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Status code for the API
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "Status code for the API")
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
  @ApiModelProperty(example = "null", value = "Textual description of the status")
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
  @ApiModelProperty(example = "null", value = "Metadata includes things like the time of creation, the version of the induction system, …")
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
