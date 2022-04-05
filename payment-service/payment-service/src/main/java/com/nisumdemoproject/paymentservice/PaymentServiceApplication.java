package com.nisumdemoproject.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@SpringBootApplication
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
		LOGGER.info("****** PaymentService Application.....******");
	}

}
