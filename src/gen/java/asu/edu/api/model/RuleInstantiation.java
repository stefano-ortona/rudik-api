package asu.edu.api.model;

import java.util.Objects;
import asu.edu.api.model.RuleResult;
import asu.edu.api.model.VariableBinding;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * RuleInstantiation
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class RuleInstantiation   {
  private RuleResult specification = null;

  private List<VariableBinding> instance = new ArrayList<VariableBinding>();

  public RuleInstantiation specification(RuleResult specification) {
    this.specification = specification;
    return this;
  }

   /**
   * Get specification
   * @return specification
  **/
  @ApiModelProperty(required = true, value = "")
  public RuleResult getSpecification() {
    return specification;
  }

  public void setSpecification(RuleResult specification) {
    this.specification = specification;
  }

  public RuleInstantiation instance(List<VariableBinding> instance) {
    this.instance = instance;
    return this;
  }

  public RuleInstantiation addInstanceItem(VariableBinding instanceItem) {
    this.instance.add(instanceItem);
    return this;
  }

   /**
   * A single instantation of the given input rule, where an array of variable bindigns assign to each varable in the rule an actual entity of the graph.
   * @return instance
  **/
  @ApiModelProperty(required = true, value = "A single instantation of the given input rule, where an array of variable bindigns assign to each varable in the rule an actual entity of the graph.")
  public List<VariableBinding> getInstance() {
    return instance;
  }

  public void setInstance(List<VariableBinding> instance) {
    this.instance = instance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RuleInstantiation ruleInstantiation = (RuleInstantiation) o;
    return Objects.equals(this.specification, ruleInstantiation.specification) &&
        Objects.equals(this.instance, ruleInstantiation.instance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(specification, instance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RuleInstantiation {\n");
    
    sb.append("    specification: ").append(toIndentedString(specification)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
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

