package com.nisumdemoproject.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
		LOGGER.info("****** OrderService Application.....******");
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
