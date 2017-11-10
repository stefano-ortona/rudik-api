package asu.edu.rule_miner.api;

import org.slf4j.Logger;

@SuppressWarnings("serial")
public class RudikApiException extends RuntimeException {
  public RudikApiException(final String message, final Logger logger) {
    super(message);
    if (logger != null) {
      logger.error(message);
    }
  }

  public RudikApiException(final String message, final Throwable cause, final Logger logger) {
    super(message, cause);
    if (logger != null) {
      logger.error(message);
    }
  }

  public RudikApiException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
