package asu.edu.rule_miner.api.factories;

import asu.edu.rule_miner.api.StatusApiService;
import asu.edu.rule_miner.api.impl.StatusApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class StatusApiServiceFactory {
    private final static StatusApiService service = new StatusApiServiceImpl();

    public static StatusApiService getStatusApi() {
        return service;
    }
}
