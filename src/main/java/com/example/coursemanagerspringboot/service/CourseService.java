package com.example.coursemanagerspringboot.service;

import com.example.coursemanagerspringboot.model.Course;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service // Marks this as a Spring-managed bean
public class CourseService {

    private final List<Course> courseList = new ArrayList<>(); // Data Storing

    public List<Course> getAllCourses(){
        return this.courseList;
    }

    public Course getCourseById(Long id){
        return this.courseList.stream().filter(course -> course.getId().equals(id))
        .findFirst()
        .orElse(null);
    }

    public Course addCourse(Course course){
        this.courseList.add(course);
        return course;
    }

    public Course updateCourse(long id, Course updatedCourse){
       for (int i = 0; i < this.courseList.size(); i++) {
            if (this.courseList.get(i).getId().equals(id)) {
                this.courseList.set(i, updatedCourse);
                return updatedCourse;
            }
       }
       return null;
    }

    public boolean deleteCourse(Long id){
        return this.courseList.removeIf(course -> course.getId().equals(id));
    }

    public List<Course> searchByName(String name) {
        return this.courseList.stream().filter(course -> course.getName().toLowerCase().contains(name.toLowerCase()))
        .toList();
    }

}
