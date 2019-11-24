package com.cg.cafemenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient(autoRegister = true)
public class CafeMenuMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeMenuMicroserviceApplication.class, args);
	}

}
