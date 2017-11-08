package asu.edu.rule_miner.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.interceptors.CorsFilter;

import io.swagger.jaxrs.config.BeanConfig;

public class FatJarApplication extends Application {

  final static String BASE_PATH = "/v1/rudik";
  final static String HOST_PORT = "localhost:8080";

  static final String APPLICATION_PATH = BASE_PATH;
  static final String CONTEXT_ROOT = "/";
  HashSet<Object> singletons = new HashSet<Object>();

  public FatJarApplication() {
    configureSwagger();
  }

  @Override
  public Set<Class<?>> getClasses() {

    final HashSet<Class<?>> set = new HashSet<Class<?>>();

    set.add(ExampleApi.class);
    set.add(RuleApi.class);
    set.add(StatusApi.class);

    set.add(io.swagger.jaxrs.listing.ApiListingResource.class);
    set.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

    return set;
  }

  @Override
  public Set<Object> getSingletons() {
    final CorsFilter corsFilter = new CorsFilter();
    corsFilter.getAllowedOrigins().add("*");
    corsFilter.setAllowedMethods("OPTIONS, GET, POST, DELETE, PUT, PATCH");
    singletons.add(corsFilter);
    return singletons;
  }

  private void configureSwagger() {
    final BeanConfig beanConfig = new BeanConfig();
    beanConfig.setVersion("1.0.0");
    beanConfig.setSchemes(new String[] { "http" });
    beanConfig.setHost(HOST_PORT);
    beanConfig.setBasePath(APPLICATION_PATH);
    beanConfig.setResourcePackage(RuleApi.class.getPackage().getName());
    beanConfig.setTitle("RuDiK 1.0 APIs");
    beanConfig.setDescription(
        "Collection of APIs for inducing declarative rules with RuDiK and few others utility methods for RDF knowledge graphs accesible via a SPARQL endpoint.");
    beanConfig.setScan(true);
  }
}
