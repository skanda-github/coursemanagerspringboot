package com.example.coursemanagerspringboot.model;

public class Course {

    private Long id; // Unique identifier for each course
    private String name; // Name of the course
    private String description; // Description of the course

    public Course() {} // Required for deserialization

    // Constructor with all fields
    public Course(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getter and setter methods for id, name, and description
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
