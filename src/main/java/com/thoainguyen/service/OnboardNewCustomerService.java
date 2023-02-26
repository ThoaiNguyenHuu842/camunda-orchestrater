package com.thoainguyen.service;

import com.thoainguyen.client.AccountServiceClient;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OnboardNewCustomerService implements JavaDelegate {

  private static final Logger LOGGER = LoggerFactory.getLogger(OnboardNewCustomerService.class);
  private final AccountServiceClient accountServiceClient;

  @Autowired
  public OnboardNewCustomerService(AccountServiceClient accountServiceClient) {
    this.accountServiceClient = accountServiceClient;
  }

  @Override
  public void execute(DelegateExecution execution) {
    String userName = execution.getBusinessKey();
    accountServiceClient.onboard(userName);
  }

}
