package com.example.coursemanagerspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Combines @Configuration, @EnableAutoConfiguration, and @ComponentScan
public class CoursemanagerspringbootApplication {

	// This is the main method, which is the entry point of a Spring Boot application
	public static void main(String[] args) {
		// Runs the Spring Boot application, which automatically starts an embedded web server
		SpringApplication.run(CoursemanagerspringbootApplication.class, args);
	}

}
