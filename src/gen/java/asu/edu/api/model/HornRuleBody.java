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
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class HornRuleBody   {
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
  @ApiModelProperty(required = true, value = "List of logical atoms which the body of the rule is made of.")
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

