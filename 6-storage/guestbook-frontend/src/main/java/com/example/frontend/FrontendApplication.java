package com.example.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.*;
import org.springframework.integration.annotation.*;
import org.springframework.integration.gcp.pubsub.outbound.PubSubMessageHandler;
import org.springframework.messaging.MessageHandler;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;

// Enable consumption of HATEOS payloads
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
// Enable Feign Clients
@EnableFeignClients
@SpringBootApplication
public class FrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontendApplication.class, args);
	}
	
	@Bean
	@ServiceActivator(inputChannel = "messagesOutputChannel")
	public MessageHandler messageSender(PubSubTemplate pubsubTemplate) {
  	  return new PubSubMessageHandler(pubsubTemplate, "messages");
	}
}
