package com.cg;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpdeskCapCafeApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/java/log4j.properties");
		SpringApplication.run(HelpdeskCapCafeApplication.class, args);
	}

}
