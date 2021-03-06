package asu.edu.rule_miner.api;

import asu.edu.rule_miner.api.*;
import asu.edu.rule_miner.api.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import asu.edu.rule_miner.api.model.ErrorModel;
import asu.edu.rule_miner.api.model.APIStatus;

import java.util.List;
import asu.edu.rule_miner.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T17:54:27.167Z")
public abstract class StatusApiService {
    public abstract Response statusAPI(Boolean full,SecurityContext securityContext) throws NotFoundException;
}
