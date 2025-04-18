package com.example.coursemanagerspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.coursemanagerspringboot.model.Course;
import com.example.coursemanagerspringboot.service.CourseService;

@RestController  // Marks this as a REST controller (returns JSON responses)
@RequestMapping("/api/courses")  // Base URL for all endpoints in this controller
public class CourseController {

    private final CourseService courseService;

    @Autowired // Injects CourseService using Spring's Dependency Injection
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses(){
        return this.courseService.getAllCourses();
    }

    @GetMapping("/{id}")  // GET /api/courses/{id}
    public Course getCourse(@PathVariable Long id){
        return this.courseService.getCourseById(id);
    }

    @PostMapping  // POST /api/courses
    public Course createCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    @PutMapping("/{id}")  // PUT /api/courses/{id}
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course){
        return this.courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")  // DELETE /api/courses/{id}
    public String deleteCourse(@PathVariable Long id){
        return this.courseService.deleteCourse(id) ? "Deleted successfully." : "Course not found.";
    }

    @GetMapping("/search")  // Search for a course by name
    public List<Course> searchCoursesByName(@RequestParam String name){
        return this.courseService.searchByName(name);
    }
}
