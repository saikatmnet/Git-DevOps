package com.devops.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class DevOpsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevOpsMicroserviceApplication.class, args);
	}

}

