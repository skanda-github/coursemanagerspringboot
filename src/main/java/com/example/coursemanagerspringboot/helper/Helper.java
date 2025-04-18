package com.example.coursemanagerspringboot.helper;

import org.springframework.stereotype.Component;

@Component
public class Helper {
    public String formatCourseName(String name){
        // Trim any leading or trailing whitespace from the course name to ensure consistency.
        // Example: "  Java Basics  " will become "Java Basics".
        name = name.trim();
        
        // Convert the course name to uppercase for standardization.
        // Example: "java basics" will become "JAVA BASICS".
        return name.toUpperCase();
    }    
}
