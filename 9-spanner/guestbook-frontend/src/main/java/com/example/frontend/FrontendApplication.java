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
import java.io.IOException;
import com.google.cloud.vision.v1.*;
import com.google.api.gax.core.CredentialsProvider;

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
	
	// This configures the Vision API settings with a credential using the
	// the scope we specified in the applications.properties.
	@Bean
	public ImageAnnotatorSettings imageAnnotatorSettings(
			CredentialsProvider credentialsProvider) throws IOException {
		return ImageAnnotatorSettings.newBuilder()
			.setCredentialsProvider(credentialsProvider).build();
	}
	
	@Bean
	public ImageAnnotatorClient imageAnnotatorClient(
			ImageAnnotatorSettings settings) throws IOException {
		return ImageAnnotatorClient.create(settings);
	}

}
