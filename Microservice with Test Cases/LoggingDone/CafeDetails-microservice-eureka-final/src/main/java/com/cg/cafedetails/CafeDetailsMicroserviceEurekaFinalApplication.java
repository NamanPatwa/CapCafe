package com.cg.cafedetails;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class CafeDetailsMicroserviceEurekaFinalApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/java/log4j.properties");

		SpringApplication.run(CafeDetailsMicroserviceEurekaFinalApplication.class, args);
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
		
	}

}
