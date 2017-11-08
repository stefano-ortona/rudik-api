package asu.edu.rule_miner.api;

import asu.edu.rule_miner.api.*;
import asu.edu.api.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import asu.edu.api.model.RuleInstantiation;
import asu.edu.api.model.ErrorModel;
import asu.edu.api.model.RuleResult;
import asu.edu.api.model.RuleSpecification;
import asu.edu.api.model.RuleStatus;

import java.util.List;
import asu.edu.rule_miner.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public abstract class RuleApiService {
    public abstract Response instantiateRule(RuleResult ruleSpecification,SecurityContext securityContext) throws NotFoundException;
    public abstract Response mineRule(RuleSpecification ruleSpecification,SecurityContext securityContext) throws NotFoundException;
}
