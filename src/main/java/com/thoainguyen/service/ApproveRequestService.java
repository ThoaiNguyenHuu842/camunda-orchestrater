package com.thoainguyen.service;

import com.thoainguyen.client.RequestManagementClient;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApproveRequestService implements JavaDelegate {

  private static final Logger LOGGER = LoggerFactory.getLogger(ApproveRequestService.class);
  private final RequestManagementClient requestManagementClient;

  @Autowired
  public ApproveRequestService(RequestManagementClient requestManagementClient) {
    this.requestManagementClient = requestManagementClient;
  }

  @Override
  public void execute(DelegateExecution execution) {
    String userName = execution.getBusinessKey();
    requestManagementClient.approve(userName);
  }

}
