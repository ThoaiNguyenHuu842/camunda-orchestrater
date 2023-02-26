package com.thoainguyen.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "AccountServiceClient", url = "http://localhost:8080/account")
public interface AccountServiceClient {
  @PostMapping(value = "/onboard/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
  void onboard(@PathVariable String userName);
}
