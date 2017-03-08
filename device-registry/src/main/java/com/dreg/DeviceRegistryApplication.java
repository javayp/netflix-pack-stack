package com.dreg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DeviceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceRegistryApplication.class, args);
	}
}
