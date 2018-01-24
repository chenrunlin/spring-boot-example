package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ExampleHelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleHelloworldApplication.class, args);
	}

	@RequestMapping("/")
	public String index(){
		return "Hello Spring Boot";
	}
}
