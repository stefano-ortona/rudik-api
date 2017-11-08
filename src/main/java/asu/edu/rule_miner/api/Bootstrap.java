package asu.edu.rule_miner.api;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.Contact;
import io.swagger.models.Info;
import io.swagger.models.License;
import io.swagger.models.Swagger;

public class Bootstrap extends HttpServlet {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Override
  public void init(ServletConfig config) throws ServletException {
    final Info info = new Info().title("Swagger Server").description(
        "Collection of APIs for inducing declarative rules with RuDiK and few others utility methods for RDF knowledge graphs accesible via a SPARQL endpoint.")
        .termsOfService("").contact(new Contact().email("stefano.ortona@meltwater.com"))
        .license(new License().name("").url(""));

    final ServletContext context = config.getServletContext();
    final Swagger swagger = new Swagger().info(info);

    new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
  }
}
