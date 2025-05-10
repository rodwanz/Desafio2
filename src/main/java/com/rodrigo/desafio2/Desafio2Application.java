package com.rodrigo.desafio2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Desafio2Application {

	public static void main(String[] args) {
		SpringApplication.run(Desafio2Application.class, args);
	}

}
