package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@EnableAutoConfiguration(exclude = { org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class })

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
}