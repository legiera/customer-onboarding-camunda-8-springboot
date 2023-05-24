package io.camunda.workshop.customer;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableZeebeClient
public class CustomerOnboardingSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerOnboardingSpringbootApplication.class, args);
	}


}
