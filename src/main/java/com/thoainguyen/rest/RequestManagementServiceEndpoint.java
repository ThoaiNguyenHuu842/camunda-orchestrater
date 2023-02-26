package com.thoainguyen.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestManagementServiceEndpoint {

  private static final Logger LOGGER = LoggerFactory.getLogger(RequestManagementServiceEndpoint.class);

  @PostMapping("/request/{userName}")
  public void storeRequest(@PathVariable String userName){
    LOGGER.info("Store request user name {}", userName);
  }

  @PostMapping("/request/approve/{userName}")
  public void approveRequest(@PathVariable String userName){
    LOGGER.info("Approve request user name {}", userName);
  }

  @PostMapping("/request/reject/{userName}")
  public void rejectRequest(@PathVariable String userName){
    LOGGER.info("Reject request user name {}", userName);
  }
}
