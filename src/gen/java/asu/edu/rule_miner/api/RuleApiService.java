package asu.edu.rule_miner.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import asu.edu.rule_miner.api.model.RuleResult;
import asu.edu.rule_miner.api.model.RuleSpecification;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T17:54:27.167Z")
public abstract class RuleApiService {
  public abstract Response instantiateRule(RuleResult ruleSpecification, SecurityContext securityContext)
      throws NotFoundException;

  public abstract Response mineRule(RuleSpecification ruleSpecification, Boolean forceMinining,
      SecurityContext securityContext) throws NotFoundException;
}
