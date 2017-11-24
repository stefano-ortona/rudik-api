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
 * RuleExample
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T17:54:27.167Z")
public class RuleExample   {
  private List<EntityPair> positive = new ArrayList<EntityPair>();

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
  @ApiModelProperty(required = true, value = "Set of positive examples.")
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
  @ApiModelProperty(required = true, value = "Set of negative examples.")
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

