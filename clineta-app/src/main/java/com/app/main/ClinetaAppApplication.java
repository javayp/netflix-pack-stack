package com.app.main;

import com.config.lbs.LoadBalancingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages= {"com.config.feign"})
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
@RibbonClient(name = "data-producer",configuration = LoadBalancingStrategy.class)
@ComponentScan("com.app")
public class ClinetaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinetaAppApplication.class, args);
	}
}
