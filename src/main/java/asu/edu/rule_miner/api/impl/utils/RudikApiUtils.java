package asu.edu.rule_miner.api.impl.utils;

import javax.ws.rs.core.Response;

import asu.edu.api.model.ErrorModel;

public class RudikApiUtils {

  private static ErrorModel errorModelFrom(final Integer statusCode, final String message) {
    final ErrorModel em = new ErrorModel();
    em.setCode(statusCode);
    em.setMessage(message);
    return em;
  }

  public static Response errorResponseFrom(final Response.Status status, final String message) {
    return Response.status(status.getStatusCode()).entity(errorModelFrom(status.getStatusCode(), message)).build();
  }

}
