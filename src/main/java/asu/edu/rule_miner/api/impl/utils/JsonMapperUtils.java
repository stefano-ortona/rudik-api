package asu.edu.rule_miner.api.impl.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonMapperUtils {

  private static ObjectMapper SINGLETON;

  private static void lazyInitialisation() {
    if (SINGLETON == null) {
      SINGLETON = new ObjectMapper();
      incudeMapperProperties(SINGLETON);
    }
  }

  public static ObjectMapper getMapper() {
    lazyInitialisation();
    return SINGLETON;
  }

  public static ObjectMapper incudeMapperProperties(final ObjectMapper mapper) {
    mapper.registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    // mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    // mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    return mapper;
  }

}
