package asu.edu.rule_miner.api.factories;

import asu.edu.rule_miner.api.ExampleApiService;
import asu.edu.rule_miner.api.impl.ExampleApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class ExampleApiServiceFactory {
    private final static ExampleApiService service = new ExampleApiServiceImpl();

    public static ExampleApiService getExampleApi() {
        return service;
    }
}
