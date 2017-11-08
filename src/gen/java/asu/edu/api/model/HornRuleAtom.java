package asu.edu.api.model;

import java.util.Objects;
import asu.edu.api.model.EntityPair;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * HornRuleAtom
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class HornRuleAtom   {
  private String predicate = null;

  private EntityPair variablePair = null;

  public HornRuleAtom predicate(String predicate) {
    this.predicate = predicate;
    return this;
  }

   /**
   * Predicate of the horn rule atom.
   * @return predicate
  **/
  @ApiModelProperty(required = true, value = "Predicate of the horn rule atom.")
  public String getPredicate() {
    return predicate;
  }

  public void setPredicate(String predicate) {
    this.predicate = predicate;
  }

  public HornRuleAtom variablePair(EntityPair variablePair) {
    this.variablePair = variablePair;
    return this;
  }

   /**
   * Get variablePair
   * @return variablePair
  **/
  @ApiModelProperty(required = true, value = "")
  public EntityPair getVariablePair() {
    return variablePair;
  }

  public void setVariablePair(EntityPair variablePair) {
    this.variablePair = variablePair;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HornRuleAtom hornRuleAtom = (HornRuleAtom) o;
    return Objects.equals(this.predicate, hornRuleAtom.predicate) &&
        Objects.equals(this.variablePair, hornRuleAtom.variablePair);
  }

  @Override
  public int hashCode() {
    return Objects.hash(predicate, variablePair);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HornRuleAtom {\n");
    
    sb.append("    predicate: ").append(toIndentedString(predicate)).append("\n");
    sb.append("    variablePair: ").append(toIndentedString(variablePair)).append("\n");
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

