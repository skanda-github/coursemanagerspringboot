package com.example.coursemanagerspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "defaultCourseTitle")
    public String courseTitle() {
        return "spring boot course";
    }
}
