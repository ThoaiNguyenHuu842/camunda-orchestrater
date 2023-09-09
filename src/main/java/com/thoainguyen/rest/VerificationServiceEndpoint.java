package com.thoainguyen.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerificationServiceEndpoint {

  private static final Logger LOGGER = LoggerFactory.getLogger(VerificationServiceEndpoint.class);

  @PostMapping("/verify/{userName}")
  public ResponseEntity verify(@PathVariable String userName) throws InterruptedException {
    if (userName.equals("thoainguyen")) {
      LOGGER.info("Verify success user name {}", userName);
      return ResponseEntity.ok().build();
    }
    else {
      LOGGER.info("Verify error user name {}", userName);
      return ResponseEntity.badRequest().build();
    }
  }
}
