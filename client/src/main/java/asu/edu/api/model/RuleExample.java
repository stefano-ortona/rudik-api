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
import asu.edu.api.model.EntityPair;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;


/**
 * RuleExample
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-08T13:58:07.522Z")
public class RuleExample   {
  @JsonProperty("positive")
  private List<EntityPair> positive = new ArrayList<EntityPair>();

  @JsonProperty("negative")
  private List<EntityPair> negative = new ArrayList<EntityPair>();

  public RuleExample positive(List<EntityPair> positive) {
    this.positive = positive;
    return this;
  }

  public RuleExample addPositiveItem(EntityPair positiveItem) {
    this.positive.add(positiveItem);
    return this;
  }

   /**
   * Set of positive examples.
   * @return positive
  **/
  @ApiModelProperty(example = "null", required = true, value = "Set of positive examples.")
  public List<EntityPair> getPositive() {
    return positive;
  }

  public void setPositive(List<EntityPair> positive) {
    this.positive = positive;
  }

  public RuleExample negative(List<EntityPair> negative) {
    this.negative = negative;
    return this;
  }

  public RuleExample addNegativeItem(EntityPair negativeItem) {
    this.negative.add(negativeItem);
    return this;
  }

   /**
   * Set of negative examples.
   * @return negative
  **/
  @ApiModelProperty(example = "null", required = true, value = "Set of negative examples.")
  public List<EntityPair> getNegative() {
    return negative;
  }

  public void setNegative(List<EntityPair> negative) {
    this.negative = negative;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RuleExample ruleExample = (RuleExample) o;
    return Objects.equals(this.positive, ruleExample.positive) &&
        Objects.equals(this.negative, ruleExample.negative);
  }

  @Override
  public int hashCode() {
    return Objects.hash(positive, negative);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RuleExample {\n");
    
    sb.append("    positive: ").append(toIndentedString(positive)).append("\n");
    sb.append("    negative: ").append(toIndentedString(negative)).append("\n");
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

