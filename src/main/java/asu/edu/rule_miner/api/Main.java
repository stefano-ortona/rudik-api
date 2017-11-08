package asu.edu.rule_miner.api;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Slf4jLog;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import asu.edu.rule_miner.rudik.configuration.ConfigurationFacility;

public class Main {

  private static final Logger logger = LoggerFactory.getLogger(Main.class);

  private static final int PORT = 8080;

  public Main() {
  }

  public static void main(final String[] args) throws Exception {
    ConfigurationFacility.getConfiguration();
    try {
      Log.setLog(new Slf4jLog());

      new Main().run();
    } catch (final Throwable t) {
      t.printStackTrace();
    }
  }

  public void run() throws Exception {

    final Server server = new Server(PORT);

    // Setup the basic Application "context" at "/".
    // This is also known as the handler tree (in Jetty speak).
    final ServletContextHandler context = new ServletContextHandler(server, FatJarApplication.CONTEXT_ROOT);

    // Setup RESTEasy's HttpServletDispatcher at "/api/*".
    final ServletHolder restEasyServlet = new ServletHolder(new HttpServletDispatcher());
    restEasyServlet.setInitParameter("resteasy.servlet.mapping.prefix", FatJarApplication.APPLICATION_PATH);
    restEasyServlet.setInitParameter("javax.ws.rs.Application", FatJarApplication.class.getCanonicalName());
    context.addServlet(restEasyServlet, FatJarApplication.APPLICATION_PATH + "/*");

    // Setup the DefaultServlet at "/".
    final ServletHolder defaultServlet = new ServletHolder(new DefaultServlet());
    context.addServlet(defaultServlet, FatJarApplication.CONTEXT_ROOT);

    // Set the path to our static (Swagger UI) resources
    // final String resourceBasePath = Main.class.getResource("/swagger-ui").toExternalForm();
    // context.setResourceBase(resourceBasePath);
    // context.setWelcomeFiles(new String[] { "index.html" });

    logger.info("API Server STARTING at {} on {}", FatJarApplication.BASE_PATH, PORT);
    server.start();
    logger.info("API Server READY at {} on {}", FatJarApplication.BASE_PATH, PORT);
    server.join();
    logger.info("API Server SHUTDOWN at {} on {}", FatJarApplication.BASE_PATH, PORT);
  }
}