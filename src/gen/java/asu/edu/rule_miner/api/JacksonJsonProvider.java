package asu.edu.rule_miner.api;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import asu.edu.rule_miner.api.impl.utils.JsonMapperUtils;

@Provider
@Produces({ MediaType.APPLICATION_JSON })
public class JacksonJsonProvider extends JacksonJaxbJsonProvider {
  private static ObjectMapper commonMapper = JsonMapperUtils.getMapper();

  public JacksonJsonProvider() {
    super.setMapper(commonMapper);
  }
}