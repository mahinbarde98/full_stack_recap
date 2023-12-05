package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
/*
* Enable server annotation to indicate the application as eureka server
 */
@EnableEurekaServer
public class ServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryApplication.class, args);
	}

}
