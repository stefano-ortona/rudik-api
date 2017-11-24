package asu.edu.rule_miner.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * HornRule
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T17:54:27.167Z")
public class HornRule {
  private HornRuleBody body = null;

  private Double score = null;

  private List<EntityPair> generationCoverage = new ArrayList<EntityPair>();

  private List<EntityPair> validationCoverage = new ArrayList<EntityPair>();

  public HornRule body(HornRuleBody body) {
    this.body = body;
    return this;
  }

  /**
   * Get body
   * @return body
   **/
  @ApiModelProperty(required = true, value = "")
  public HornRuleBody getBody() {
    return body;
  }

  public void setBody(HornRuleBody body) {
    this.body = body;
  }

  public HornRule score(Double score) {
    this.score = score;
    return this;
  }

  /**
   * Get score
   * @return score
   **/
  @ApiModelProperty(value = "Confidence score given to output rules.")
  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }

  public HornRule generationCoverage(List<EntityPair> generationCoverage) {
    this.generationCoverage = generationCoverage;
    return this;
  }

  public HornRule addGenerationCoverageItem(EntityPair generationCoverageItem) {
    this.generationCoverage.add(generationCoverageItem);
    return this;
  }

  /**
   * Generation examples covered by the rule.
   * @return generationCoverage
   **/
  @ApiModelProperty(value = "Generation examples covered by the rule.")
  public List<EntityPair> getGenerationCoverage() {
    return generationCoverage;
  }

  public void setGenerationCoverage(List<EntityPair> generationCoverage) {
    this.generationCoverage = generationCoverage;
  }

  public HornRule validationCoverage(List<EntityPair> validationCoverage) {
    this.validationCoverage = validationCoverage;
    return this;
  }

  public HornRule addValidationCoverageItem(EntityPair validationCoverageItem) {
    this.validationCoverage.add(validationCoverageItem);
    return this;
  }

  /**
   * Validation examples covered by the rule.
   * @return validationCoverage
   **/
  @ApiModelProperty(value = "Validation examples covered by the rule.")
  public List<EntityPair> getValidationCoverage() {
    return validationCoverage;
  }

  public void setValidationCoverage(List<EntityPair> validationCoverage) {
    this.validationCoverage = validationCoverage;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final HornRule hornRule = (HornRule) o;
    return Objects.equals(this.body, hornRule.body)
        && Objects.equals(this.generationCoverage, hornRule.generationCoverage)
        && Objects.equals(this.validationCoverage, hornRule.validationCoverage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(body, generationCoverage, validationCoverage);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("class HornRule {\n");

    sb.append("    body: ").append(toIndentedString(body)).append("\n");
    sb.append("    generationCoverage: ").append(toIndentedString(generationCoverage)).append("\n");
    sb.append("    validationCoverage: ").append(toIndentedString(validationCoverage)).append("\n");
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
