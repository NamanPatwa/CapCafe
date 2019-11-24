package com.cg;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author team 1
 * @version 1 Class Containing main Method To Start the application
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.cg")
public class CafeOrderMicroserviceApplication {
	static Logger myLogger =  Logger.getLogger(CafeOrderMicroserviceApplication.class);
	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/java/log4j.properties");
		myLogger.info("Main method Initiated");
		SpringApplication.run(CafeOrderMicroserviceApplication.class, args);
	}

}
