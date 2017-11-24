package asu.edu.rule_miner.api.model;

import java.util.Objects;
import asu.edu.rule_miner.api.model.EntityPair;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * VariableBinding
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T17:54:27.167Z")
public class VariableBinding   {
  private List<EntityPair> binding = new ArrayList<EntityPair>();

  public VariableBinding binding(List<EntityPair> binding) {
    this.binding = binding;
    return this;
  }

  public VariableBinding addBindingItem(EntityPair bindingItem) {
    this.binding.add(bindingItem);
    return this;
  }

   /**
   * A binding between a variable expressed in the subject, and an actual entity expressed in the object.
   * @return binding
  **/
  @ApiModelProperty(required = true, value = "A binding between a variable expressed in the subject, and an actual entity expressed in the object.")
  public List<EntityPair> getBinding() {
    return binding;
  }

  public void setBinding(List<EntityPair> binding) {
    this.binding = binding;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VariableBinding variableBinding = (VariableBinding) o;
    return Objects.equals(this.binding, variableBinding.binding);
  }

  @Override
  public int hashCode() {
    return Objects.hash(binding);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VariableBinding {\n");
    
    sb.append("    binding: ").append(toIndentedString(binding)).append("\n");
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

