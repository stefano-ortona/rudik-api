package asu.edu.rule_miner.api.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import asu.edu.api.model.RuleResult;
import asu.edu.api.model.RuleSpecification;
import asu.edu.rule_miner.api.ApiResponseMessage;
import asu.edu.rule_miner.api.NotFoundException;
import asu.edu.rule_miner.api.RuleApiService;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class RuleApiServiceImpl extends RuleApiService {
  @Override
  public Response instantiateRule(RuleResult ruleSpecification, SecurityContext securityContext)
      throws NotFoundException {
    System.out.println("DO SOME MAGIC!");

    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response mineRule(RuleSpecification ruleSpecification, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }
}
