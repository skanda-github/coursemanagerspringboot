package com.example.coursemanagerspringboot.helper;

import org.springframework.stereotype.Component;

@Component
public class Helper {

    public String formatCourseName(String name){
        return name.trim().toUpperCase();
    }
}
