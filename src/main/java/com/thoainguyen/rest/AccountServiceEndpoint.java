package com.thoainguyen.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountServiceEndpoint {

  private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceEndpoint.class);

  @PostMapping("/account/onboard/{userName}")
  public void onboard(@PathVariable String userName){
    LOGGER.info("Onboard account {}", userName);
  }

  @PostMapping("/account/reject/{userName}")
  public void reject(@PathVariable String userName) throws InterruptedException {
    LOGGER.info("Reject account {}", userName);
  }
}
