package com.message.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.message")
public class RawDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(RawDataApplication.class, args);
	}
}
