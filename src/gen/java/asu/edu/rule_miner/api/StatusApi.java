package asu.edu.rule_miner.api;

import asu.edu.api.model.*;
import asu.edu.rule_miner.api.StatusApiService;
import asu.edu.rule_miner.api.factories.StatusApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import asu.edu.api.model.ErrorModel;
import asu.edu.api.model.APIStatus;

import java.util.List;
import asu.edu.rule_miner.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/_status")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the _status API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class StatusApi  {
   private final StatusApiService delegate = StatusApiServiceFactory.getStatusApi();

    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Status of APIs", notes = "Retrieves the status of the APIs", response = APIStatus.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "The API is up and running", response = APIStatus.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Unexpected error", response = APIStatus.class) })
    public Response statusAPI(@ApiParam(value = "Return the curren status of the API.") @QueryParam("full") Boolean full
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.statusAPI(full,securityContext);
    }
}
