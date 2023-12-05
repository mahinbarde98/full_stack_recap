package com.stackroute.Async.Processing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Enables Spring Boot auto config and component scanning.
 */
@SpringBootApplication
@EnableAsync
public class AsyncProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncProcessingApplication.class, args);
	}

}
