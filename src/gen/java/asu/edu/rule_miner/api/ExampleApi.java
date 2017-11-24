package asu.edu.rule_miner.api;

import asu.edu.rule_miner.api.model.*;
import asu.edu.rule_miner.api.ExampleApiService;
import asu.edu.rule_miner.api.factories.ExampleApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import asu.edu.rule_miner.api.model.ErrorModel;
import asu.edu.rule_miner.api.model.RuleSpecification;
import asu.edu.rule_miner.api.model.RuleExample;
import asu.edu.rule_miner.api.model.EntityPair;

import java.util.List;
import asu.edu.rule_miner.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/example")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the example API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T17:54:27.167Z")
public class ExampleApi  {
   private final ExampleApiService delegate = ExampleApiServiceFactory.getExampleApi();

    @POST
    @Path("/generation")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Positive and Negative Example Generation", notes = "Generate positive and negative examples for the given target predicate. If types of subject and/or object are not specified, then the most common ones from the graph will be used. If more than one target relation is specified, then only the first predicate will be used for the generation.", response = RuleExample.class, tags={ "example", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The request has been successfully received and the positive and negative examples have been returned.", response = RuleExample.class),
        
        @io.swagger.annotations.ApiResponse(code = 408, message = "The input request went in timeout. This most likely happens when the SPARQL endpoint is not able of producing positive and/or negative examples with customised heuristics.", response = RuleExample.class),
        
        @io.swagger.annotations.ApiResponse(code = 412, message = "The input rule specification is not valid.", response = RuleExample.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Unexpected error.", response = RuleExample.class) })
    public Response exampleGeneration(@ApiParam(value = "Specifies the input target predicate for which positive and negative examples will be generated." ,required=true) RuleSpecification predicateSpecification
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.exampleGeneration(predicateSpecification,securityContext);
    }
    @POST
    @Path("/type")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Most Common Type Example Generation", notes = "Generate most common types for subject and object examples for the given input target predicate according to the graph.", response = EntityPair.class, tags={ "example", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The request has been successfully received and the most common types for both subject and object have been returned.", response = EntityPair.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "The input rule specification is not valid.", response = EntityPair.class),
        
        @io.swagger.annotations.ApiResponse(code = 408, message = "The input request went in timeout. This most likely happens when the SPARQL endpoint is not able of producing most common types for either subject or object.", response = EntityPair.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Unexpected error.", response = EntityPair.class) })
    public Response exampleType(@ApiParam(value = "Specifies the input target predicate for which most common types for subject and object will be generated." ,required=true) RuleSpecification predicateSpecification
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.exampleType(predicateSpecification,securityContext);
    }
}
