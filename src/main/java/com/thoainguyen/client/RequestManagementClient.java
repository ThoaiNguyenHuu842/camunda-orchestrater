package com.thoainguyen.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "RequestManagementClient", url = "http://localhost:8080/request")
public interface RequestManagementClient {
  @PostMapping(value = "/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
  void storeRequest(@PathVariable String userName);

  @PostMapping(value = "/reject/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
  void reject(@PathVariable String userName);

  @PostMapping(value = "/approve/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
  void approve(@PathVariable String userName);
}
