package asu.edu.rule_miner.api.impl.model;

import asu.edu.rule_miner.api.model.RuleResult;
import asu.edu.rule_miner.api.model.RuleSpecification;

public interface RuleStorage {

  boolean storeRule(final RuleResult ruleResult, final String ruleId);

  RuleResult getStoredResult(RuleSpecification ruleSpecification, String ruleId);

  String getEndpointResult(RuleSpecification ruleSpecification, String ruleId);

}
