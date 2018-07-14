package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gcp.pubsub.core.*;


@SpringBootApplication
public class DemoApplication {
	@Bean
	public CommandLineRunner cli(PubSubTemplate pubSubTemplate) {
		return (args) -> {
			pubSubTemplate.subscribe("messages-subscription-1", (msg, ackConsumer) -> {
				System.out.println(msg.getData().toStringUtf8());
				ackConsumer.ack();
			});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
