package asu.edu.rule_miner.api.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import asu.edu.api.model.RuleSpecification;
import asu.edu.rule_miner.api.ApiResponseMessage;
import asu.edu.rule_miner.api.ExampleApiService;
import asu.edu.rule_miner.api.NotFoundException;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class ExampleApiServiceImpl extends ExampleApiService {
  @Override
  public Response exampleGeneration(RuleSpecification predicateSpecification, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }

  @Override
  public Response exampleType(RuleSpecification predicateSpecification, SecurityContext securityContext)
      throws NotFoundException {
    // do some magic!
    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
  }
}
