package asu.edu.rule_miner.api.impl.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonMapperUtils {

  private static ObjectMapper SINGLETON;

  private static void lazyInitialisation() {
    if (SINGLETON == null) {
      SINGLETON = new ObjectMapper();
      SINGLETON.registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
      SINGLETON.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
  }

  public static ObjectMapper getMapper() {
    lazyInitialisation();
    return SINGLETON;
  }

}
