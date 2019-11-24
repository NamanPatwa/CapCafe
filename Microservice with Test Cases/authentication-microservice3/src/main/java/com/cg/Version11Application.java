package com.cg;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Version11Application {

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/java/log4j.properties");
		SpringApplication.run(Version11Application.class, args);
	}

}
