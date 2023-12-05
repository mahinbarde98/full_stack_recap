package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*Enable Rabbit annotation*/

@SpringBootApplication
public class ConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerServiceApplication.class, args);
	}


}
