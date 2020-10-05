
package com.capgemini.flightscheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class FlightManagementApplication {

	public static void main(String[] args){
		
		SpringApplication.run(FlightManagementApplication.class, args);
		System.out.println("Started Spring Boot Application");
	}
	
	@Bean
	
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

}
