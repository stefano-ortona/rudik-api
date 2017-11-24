package asu.edu.rule_miner.api.model;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * RuleStatistics
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T17:54:27.167Z")
public class RuleStatistics {
  private Integer subgraphNodes = null;

  private Integer subgraphEdges = null;

  private Double validationTotTime = null;

  private Double validationAvgTime = null;

  private Integer validationQueries = null;

  private Double expansionTotTime = null;

  private Double expansionAvgTime = null;

  private Integer expansionQueries = null;

  private Double positiveExamplesTime = null;

  private Double negativeExamplesTime = null;

  private Double runTime = null;

  public RuleStatistics subgraphNodes(Integer subgraphNodes) {
    this.subgraphNodes = subgraphNodes;
    return this;
  }

  /**
  * Total number of nodes visited in the generated subgraph for the induction.
  * @return subgraphNodes
  **/
  @ApiModelProperty(value = "Total number of nodes visited in the generated subgraph for the induction.")
  public Integer getSubgraphNodes() {
    return subgraphNodes;
  }

  public void setSubgraphNodes(Integer subgraphNodes) {
    this.subgraphNodes = subgraphNodes;
  }

  public RuleStatistics subgraphEdges(Integer subgraphEdges) {
    this.subgraphEdges = subgraphEdges;
    return this;
  }

  /**
  * Total number of edges visited in the generated subgraph for the induction.
  * @return subgraphEdges
  **/
  @ApiModelProperty(value = "Total number of edges visited in the generated subgraph for the induction.")
  public Integer getSubgraphEdges() {
    return subgraphEdges;
  }

  public void setSubgraphEdges(Integer subgraphEdges) {
    this.subgraphEdges = subgraphEdges;
  }

  public RuleStatistics validationTotTime(Double validationTotTime) {
    this.validationTotTime = validationTotTime;
    return this;
  }

  /**
  * Total time spent for executing validation queries in seconds.
  * @return validationTotTime
  **/
  @ApiModelProperty(value = "Total time spent for executing validation queries in seconds.")
  public Double getValidationTotTime() {
    return validationTotTime;
  }

  public void setValidationTotTime(Double validationTotTime) {
    this.validationTotTime = validationTotTime;
  }

  public RuleStatistics validationAvgTime(Double validationAvgTime) {
    this.validationAvgTime = validationAvgTime;
    return this;
  }

  /**
  * Average time spent for executing validation queries in seconds.
  * @return validationAvgTime
  **/
  @ApiModelProperty(value = "Average time spent for executing validation queries in seconds.")
  public Double getValidationAvgTime() {
    return validationAvgTime;
  }

  public void setValidationAvgTime(Double validationAvgTime) {
    this.validationAvgTime = validationAvgTime;
  }

  public RuleStatistics validationQueries(Integer validationQueries) {
    this.validationQueries = validationQueries;
    return this;
  }

  /**
  * Total number of executed validation queries.
  * @return validationQueries
  **/
  @ApiModelProperty(value = "Total number of executed validation queries.")
  public Integer getValidationQueries() {
    return validationQueries;
  }

  public void setValidationQueries(Integer validationQueries) {
    this.validationQueries = validationQueries;
  }

  public RuleStatistics expansionTotTime(Double expansionTotTime) {
    this.expansionTotTime = expansionTotTime;
    return this;
  }

  /**
  * Total time spent for executing expansion queries in seconds.
  * @return expansionTotTime
  **/
  @ApiModelProperty(value = "Total time spent for executing expansion queries in seconds.")
  public Double getExpansionTotTime() {
    return expansionTotTime;
  }

  public void setExpansionTotTime(Double expansionTotTime) {
    this.expansionTotTime = expansionTotTime;
  }

  public RuleStatistics expansionAvgTime(Double expansionAvgTime) {
    this.expansionAvgTime = expansionAvgTime;
    return this;
  }

  /**
  * Average time spent for executing expansion queries in seconds.
  * @return expansionAvgTime
  **/
  @ApiModelProperty(value = "Average time spent for executing expansion queries in seconds.")
  public Double getExpansionAvgTime() {
    return expansionAvgTime;
  }

  public void setExpansionAvgTime(Double expansionAvgTime) {
    this.expansionAvgTime = expansionAvgTime;
  }

  public RuleStatistics expansionQueries(Integer expansionQueries) {
    this.expansionQueries = expansionQueries;
    return this;
  }

  /**
  * Total number of executed expansion queries.
  * @return expansionQueries
  **/
  @ApiModelProperty(value = "Total number of executed expansion queries.")
  public Integer getExpansionQueries() {
    return expansionQueries;
  }

  public void setExpansionQueries(Integer expansionQueries) {
    this.expansionQueries = expansionQueries;
  }

  public RuleStatistics positiveExamplesTime(Double positiveExamplesTime) {
    this.positiveExamplesTime = positiveExamplesTime;
    return this;
  }

  /**
  * Total time in seconds spent for generating positive examples.
  * @return positiveExamplesTime
  **/
  @ApiModelProperty(value = "Total time in seconds spent for generating positive examples.")
  public Double getPositiveExamplesTime() {
    return positiveExamplesTime;
  }

  public void setPositiveExamplesTime(Double positiveExamplesTime) {
    this.positiveExamplesTime = positiveExamplesTime;
  }

  public RuleStatistics negativeExamplesTime(Double negativeExamplesTime) {
    this.negativeExamplesTime = negativeExamplesTime;
    return this;
  }

  /**
  * Total time in seconds spent for generating negative examples.
  * @return negativeExamplesTime
  **/
  @ApiModelProperty(value = "Total time in seconds spent for generating negative examples.")
  public Double getNegativeExamplesTime() {
    return negativeExamplesTime;
  }

  public void setNegativeExamplesTime(Double negativeExamplesTime) {
    this.negativeExamplesTime = negativeExamplesTime;
  }

  public RuleStatistics runTime(Double runTime) {
    this.runTime = runTime;
    return this;
  }

  /**
  * Total running time in seconds spent for rules induction.
  * @return runTime
  **/
  @ApiModelProperty(value = "Total running time in seconds spent for rules induction.")
  public Double getRunTime() {
    return runTime;
  }

  public void setRunTime(Double runTime) {
    this.runTime = runTime;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final RuleStatistics ruleStatistics = (RuleStatistics) o;
    return Objects.equals(this.subgraphNodes, ruleStatistics.subgraphNodes)
        && Objects.equals(this.subgraphEdges, ruleStatistics.subgraphEdges)
        && Objects.equals(this.validationTotTime, ruleStatistics.validationTotTime)
        && Objects.equals(this.validationAvgTime, ruleStatistics.validationAvgTime)
        && Objects.equals(this.validationQueries, ruleStatistics.validationQueries)
        && Objects.equals(this.expansionTotTime, ruleStatistics.expansionTotTime)
        && Objects.equals(this.expansionAvgTime, ruleStatistics.expansionAvgTime)
        && Objects.equals(this.expansionQueries, ruleStatistics.expansionQueries)
        && Objects.equals(this.positiveExamplesTime, ruleStatistics.positiveExamplesTime)
        && Objects.equals(this.negativeExamplesTime, ruleStatistics.negativeExamplesTime)
        && Objects.equals(this.runTime, ruleStatistics.runTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subgraphNodes, subgraphEdges, validationTotTime, validationAvgTime, validationQueries,
        expansionTotTime, expansionAvgTime, expansionQueries, positiveExamplesTime, negativeExamplesTime, runTime);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("class RuleStatistics {\n");

    sb.append("    subgraphNodes: ").append(toIndentedString(subgraphNodes)).append("\n");
    sb.append("    subgraphEdges: ").append(toIndentedString(subgraphEdges)).append("\n");
    sb.append("    validationTotTime: ").append(toIndentedString(validationTotTime)).append("\n");
    sb.append("    validationAvgTime: ").append(toIndentedString(validationAvgTime)).append("\n");
    sb.append("    validationQueries: ").append(toIndentedString(validationQueries)).append("\n");
    sb.append("    expansionTotTime: ").append(toIndentedString(expansionTotTime)).append("\n");
    sb.append("    expansionAvgTime: ").append(toIndentedString(expansionAvgTime)).append("\n");
    sb.append("    expansionQueries: ").append(toIndentedString(expansionQueries)).append("\n");
    sb.append("    positiveExamplesTime: ").append(toIndentedString(positiveExamplesTime)).append("\n");
    sb.append("    negativeExamplesTime: ").append(toIndentedString(negativeExamplesTime)).append("\n");
    sb.append("    runTime: ").append(toIndentedString(runTime)).append("\n");
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
