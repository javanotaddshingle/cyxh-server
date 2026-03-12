package com.example.ciyuanxingheserver.controller;

import com.example.ciyuanxingheserver.entity.Course;
import com.example.ciyuanxingheserver.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/language/{language}")
    public List<Course> getCoursesByLanguage(@PathVariable String language) {
        return courseService.getCoursesByLanguage(language);
    }

    @GetMapping("/user/{userId}")
    public List<Course> getCoursesByUserId(@PathVariable Long userId) {
        return courseService.getCoursesByUserId(userId);
    }

    @GetMapping("/search/{keyword}")
    public List<Course> searchCourses(@PathVariable String keyword) {
        return courseService.searchCourses(keyword);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @PostMapping("/{id}/enroll")
    public Course enrollCourse(@PathVariable Long id) {
        return courseService.enrollCourse(id);
    }
}