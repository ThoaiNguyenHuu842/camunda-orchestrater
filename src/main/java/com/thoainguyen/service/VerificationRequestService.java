package com.thoainguyen.service;

import com.thoainguyen.client.VerificationServiceClient;
import feign.FeignException;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerificationRequestService implements JavaDelegate {

  private static final Logger LOGGER = LoggerFactory.getLogger(VerificationRequestService.class);
  private final VerificationServiceClient verificationServiceClient;

  @Autowired
  public VerificationRequestService( VerificationServiceClient verificationServiceClient) {
    this.verificationServiceClient = verificationServiceClient;
  }

  @Override
  public void execute(DelegateExecution execution) {
    String userName = execution.getBusinessKey();
    try {
      verificationServiceClient.verify(userName);
      execution.setVariable("VERIFIED",true);
    }
    catch (FeignException exception) {
      execution.setVariable("VERIFIED",false);
    }
  }

}
