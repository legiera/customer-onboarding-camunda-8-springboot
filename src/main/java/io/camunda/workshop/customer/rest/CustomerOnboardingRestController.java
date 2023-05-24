package io.camunda.workshop.customer.rest;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import io.camunda.zeebe.client.ZeebeClient;

@RestController
public class CustomerOnboardingRestController {

  private Logger logger = LoggerFactory.getLogger(CustomerOnboardingRestController.class);

  @Autowired
  private ZeebeClient client;

  @PutMapping("/customer")
  public ResponseEntity<CustomerOnboardingResponse> onboardCustomer(ServerWebExchange exchange) {
    onboardCustomer();
    return ResponseEntity.status(HttpStatus.ACCEPTED).build();
  }

  public void onboardCustomer() {
    HashMap<String, Object> variables = new HashMap<String, Object>();
    variables.put("automaticProcessing", true);
    variables.put("age", 20);
    variables.put("earnings", 8000);

    client.newCreateInstanceCommand()
            .bpmnProcessId("bank-account-simple")
            .latestVersion()
            .variables(variables)
            .send().join();

    logger.info("Gained new customer!");
  }

  public static class CustomerOnboardingResponse {
  }
}
