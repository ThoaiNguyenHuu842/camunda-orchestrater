package com.thoainguyen.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "VerificationServiceClient", url = "http://localhost:8080/verify")
public interface VerificationServiceClient {
  @PostMapping(value = "/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
  void verify(@PathVariable String userName);
}
