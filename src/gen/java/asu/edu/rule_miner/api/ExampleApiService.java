package asu.edu.rule_miner.api;

import asu.edu.rule_miner.api.*;
import asu.edu.rule_miner.api.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import asu.edu.rule_miner.api.model.ErrorModel;
import asu.edu.rule_miner.api.model.RuleSpecification;
import asu.edu.rule_miner.api.model.RuleExample;
import asu.edu.rule_miner.api.model.EntityPair;

import java.util.List;
import asu.edu.rule_miner.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T17:54:27.167Z")
public abstract class ExampleApiService {
    public abstract Response exampleGeneration(RuleSpecification predicateSpecification,SecurityContext securityContext) throws NotFoundException;
    public abstract Response exampleType(RuleSpecification predicateSpecification,SecurityContext securityContext) throws NotFoundException;
}
