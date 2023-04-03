package edu.infnet.al;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiQuoteManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiQuoteManagerApplication.class, args);
	}

}
