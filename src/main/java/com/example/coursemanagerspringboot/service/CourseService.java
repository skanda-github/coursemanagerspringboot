package com.example.coursemanagerspringboot.service;

import com.example.coursemanagerspringboot.helper.Helper;
import com.example.coursemanagerspringboot.model.Course;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service // Marks this as a Spring-managed bean
public class CourseService {

    private final Helper helper;
    private final String defaultCourseTitle;

    @Autowired
    public CourseService(Helper helper, @Qualifier("defaultCourseTitle") String defaultCourseTitle){
        this.helper = helper;
        this.defaultCourseTitle = defaultCourseTitle;

        // Initialize with two default courses
        courseList.add(new Course(1L, helper.formatCourseName("java"), "dummy"));
        courseList.add(new Course(2L, helper.formatCourseName(this.defaultCourseTitle), "dummy"));
    }

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
        course.setName(helper.formatCourseName(course.getName()));
        this.courseList.add(course);
        return course;
    }

    public Course updateCourse(long id, Course updatedCourse){
       for (int i = 0; i < this.courseList.size(); i++) {
            if (this.courseList.get(i).getId().equals(id)) {
                updatedCourse.setName(helper.formatCourseName(updatedCourse.getName()));
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
