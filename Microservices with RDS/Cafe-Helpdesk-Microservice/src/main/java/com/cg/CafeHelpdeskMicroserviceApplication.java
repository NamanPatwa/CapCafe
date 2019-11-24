package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class CafeHelpdeskMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeHelpdeskMicroserviceApplication.class, args);
	}

}
