package com.example.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

// Enable consumption of HATEOS payloads
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
// Enable Feign Clients
@EnableFeignClients
@SpringBootApplication
public class FrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontendApplication.class, args);
	}
}
