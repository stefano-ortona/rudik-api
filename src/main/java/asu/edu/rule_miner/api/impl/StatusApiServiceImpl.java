package asu.edu.rule_miner.api.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import asu.edu.rule_miner.api.NotFoundException;
import asu.edu.rule_miner.api.StatusApiService;
import asu.edu.rule_miner.api.impl.configuration.ConfigurationFacility;
import asu.edu.rule_miner.api.model.APIStatus;
import asu.edu.rule_miner.api.model.ErrorModel;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class StatusApiServiceImpl extends StatusApiService {

  private static final Logger LOGGER = LoggerFactory.getLogger(StatusApiServiceImpl.class);

  @Override
  public Response statusAPI(Boolean full, SecurityContext securityContext) throws NotFoundException {
    // check the configuration file can be retrieved and it is ok
    String errorMsg = null;
    try {
      if (ConfigurationFacility.getInstance() != null) {
        return Response.ok().entity(new APIStatus().status("Happy and Glorious ♔")
            .description("RuDiK API is up and running and ready to be invoked.")).build();
      } else {
        errorMsg = "Application configuration is set to null.";
      }
    } catch (final Exception e) {
      errorMsg = e.getMessage();
    }
    // there was an error
    // return HTTP 500
    LOGGER.error("Internal server error: {}", errorMsg);
    final ErrorModel em = new ErrorModel();
    em.setCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    em.setMessage(StringUtils.join("Internal server error: ", errorMsg));
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(em).build();
  }
}