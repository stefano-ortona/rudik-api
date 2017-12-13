package asu.edu.rule_miner.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * RuleResult
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T17:54:27.167Z")
public class RuleResult {
  private String id = null;

  private Date timeComputed = new Date();

  private RuleSpecification specification = null;

  private RuleStatistics statistics = null;

  private List<HornRule> rule = new ArrayList<HornRule>();

  private List<KeyValuePair> metadata = new ArrayList<KeyValuePair>();

  public RuleResult id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID of the rule result. Currently same one used for the RuleSpecification+TimeStamp of retrieval.
   * @return id
   **/
  @ApiModelProperty(required = true, value = "ID of the rule result. Currently same one used for the RuleSpecification+TimeStamp of retrieval.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RuleResult timeComputed(Date timeComputed) {
    this.timeComputed = timeComputed;
    return this;
  }

  /**
   * ID of the rule result. Currently same one used for the RuleSpecification+TimeStamp of retrieval.
   * @return id
   **/
  @ApiModelProperty(required = true, value = "Time stamp of when this rule result was computed.")
  public Date getTimeComputed() {
    return this.timeComputed;
  }

  public void setTimeComputed(Date time) {
    this.timeComputed = time;
  }

  public RuleResult specification(RuleSpecification specification) {
    this.specification = specification;
    return this;
  }

  /**
   * Get specification
   * @return specification
   **/
  @ApiModelProperty(required = true, value = "")
  public RuleSpecification getSpecification() {
    return specification;
  }

  public void setSpecification(RuleSpecification specification) {
    this.specification = specification;
  }

  public RuleResult statistics(RuleStatistics statistics) {
    this.statistics = statistics;
    return this;
  }

  /**
   * Get statistics
   * @return statistics
   **/
  @ApiModelProperty(value = "")
  public RuleStatistics getStatistics() {
    return statistics;
  }

  public void setStatistics(RuleStatistics statistics) {
    this.statistics = statistics;
  }

  public RuleResult rule(List<HornRule> rule) {
    this.rule = rule;
    return this;
  }

  public RuleResult addRuleItem(HornRule ruleItem) {
    this.rule.add(ruleItem);
    return this;
  }

  /**
   * Output logical body rules produced by RuDiK including their statistics.
   * @return rule
   **/
  @ApiModelProperty(required = true, value = "Output logical body rules produced by RuDiK including their statistics.")
  public List<HornRule> getRule() {
    return rule;
  }

  public void setRule(List<HornRule> rule) {
    this.rule = rule;
  }

  public RuleResult metadata(List<KeyValuePair> metadata) {
    this.metadata = metadata;
    return this;
  }

  public RuleResult addMetadataItem(KeyValuePair metadataItem) {
    this.metadata.add(metadataItem);
    return this;
  }

  /**
   * Metadata includes things like the time of creation, the version of the induction system, …
   * @return metadata
   **/
  @ApiModelProperty(value = "Metadata includes things like the time of creation, the version of the induction system, …")
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
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final RuleResult ruleResult = (RuleResult) o;
    return Objects.equals(this.id, ruleResult.id) && Objects.equals(this.specification, ruleResult.specification)
        && Objects.equals(this.statistics, ruleResult.statistics) && Objects.equals(this.rule, ruleResult.rule)
        && Objects.equals(this.metadata, ruleResult.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, specification, statistics, rule, metadata);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("class RuleResult {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    specification: ").append(toIndentedString(specification)).append("\n");
    sb.append("    statistics: ").append(toIndentedString(statistics)).append("\n");
    sb.append("    rule: ").append(toIndentedString(rule)).append("\n");
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
