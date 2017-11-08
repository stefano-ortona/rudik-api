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
import asu.edu.api.model.HornRuleAtom;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;


/**
 * HornRuleBody
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-08T13:58:07.522Z")
public class HornRuleBody   {
  @JsonProperty("atom")
  private List<HornRuleAtom> atom = new ArrayList<HornRuleAtom>();

  public HornRuleBody atom(List<HornRuleAtom> atom) {
    this.atom = atom;
    return this;
  }

  public HornRuleBody addAtomItem(HornRuleAtom atomItem) {
    this.atom.add(atomItem);
    return this;
  }

   /**
   * List of logical atoms which the body of the rule is made of.
   * @return atom
  **/
  @ApiModelProperty(example = "null", required = true, value = "List of logical atoms which the body of the rule is made of.")
  public List<HornRuleAtom> getAtom() {
    return atom;
  }

  public void setAtom(List<HornRuleAtom> atom) {
    this.atom = atom;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HornRuleBody hornRuleBody = (HornRuleBody) o;
    return Objects.equals(this.atom, hornRuleBody.atom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(atom);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HornRuleBody {\n");
    
    sb.append("    atom: ").append(toIndentedString(atom)).append("\n");
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

