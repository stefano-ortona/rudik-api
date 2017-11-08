package asu.edu.rule_miner.api.factories;

import asu.edu.rule_miner.api.RuleApiService;
import asu.edu.rule_miner.api.impl.RuleApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class RuleApiServiceFactory {
    private final static RuleApiService service = new RuleApiServiceImpl();

    public static RuleApiService getRuleApi() {
        return service;
    }
}
