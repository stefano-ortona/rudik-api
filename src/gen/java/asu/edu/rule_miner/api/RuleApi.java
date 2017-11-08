package asu.edu.rule_miner.api;

import asu.edu.api.model.*;
import asu.edu.rule_miner.api.RuleApiService;
import asu.edu.rule_miner.api.factories.RuleApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import asu.edu.api.model.RuleInstantiation;
import asu.edu.api.model.ErrorModel;
import asu.edu.api.model.RuleResult;
import asu.edu.api.model.RuleSpecification;
import asu.edu.api.model.RuleStatus;

import java.util.List;
import asu.edu.rule_miner.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/rule")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the rule API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class RuleApi  {
   private final RuleApiService delegate = RuleApiServiceFactory.getRuleApi();

    @POST
    @Path("/instantiate")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Horn Rules Instantiation over the Graph", notes = "Instantiate the given rule over the graph to compute new generated facts in case of positive rules, or potential erroneous triples in case of negative rules.", response = RuleInstantiation.class, tags={ "rule", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The request has been successfully received and the facts instantiated over the graph have been returned.", response = RuleInstantiation.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The input rule specification is not valid.", response = RuleInstantiation.class),
        
        @io.swagger.annotations.ApiResponse(code = 408, message = "The input request went in timeout. This most likely happens when the SPARQL endpoint is not able of instantiating the input rule over the graph.", response = RuleInstantiation.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Unexpected error.", response = RuleInstantiation.class) })
    public Response instantiateRule(@ApiParam(value = "Specifies the input rule to be instantiated over the graph" ,required=true) RuleResult ruleSpecification
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.instantiateRule(ruleSpecification,securityContext);
    }
    @POST
    @Path("/mine")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Horn Rules Mining", notes = "Triggers the induction of a set of logical rules for the given knwoledge graph and a target predicate. The call is asynchronous, and the computed rules will be stored and they can be retrieved as soon as the mining is complete.", response = RuleResult.class, tags={ "rule", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The request has been successfully received and the mining process has ended with results returned.", response = RuleResult.class),
        
        @io.swagger.annotations.ApiResponse(code = 202, message = "The request has been successfully received and the mining process has started.", response = RuleResult.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The input rule specification is not valid.", response = RuleResult.class),
        
        @io.swagger.annotations.ApiResponse(code = 416, message = "The request has been received but the current endpoint is busy processing another request.", response = RuleResult.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Unexpected error.", response = RuleResult.class) })
    public Response mineRule(@ApiParam(value = "Specifies the predicate and mining parametets for rule induction." ,required=true) RuleSpecification ruleSpecification
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.mineRule(ruleSpecification,securityContext);
    }
}
