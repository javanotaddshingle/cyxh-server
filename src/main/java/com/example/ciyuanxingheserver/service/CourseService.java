package com.example.ciyuanxingheserver.service;

import com.example.ciyuanxingheserver.entity.Course;
import com.example.ciyuanxingheserver.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        course.setCreatedAt(new Date());
        course.setUpdatedAt(new Date());
        course.setEnrollments(0);
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> getCoursesByLanguage(String language) {
        return courseRepository.findByLanguage(language);
    }

    public List<Course> getCoursesByUserId(Long userId) {
        return courseRepository.findByUserId(userId);
    }

    public List<Course> searchCourses(String keyword) {
        return courseRepository.findByTitleContaining(keyword);
    }

    public Course updateCourse(Course course) {
        course.setUpdatedAt(new Date());
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public Course enrollCourse(Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setEnrollments(course.getEnrollments() + 1);
            courseRepository.save(course);
        }
        return course;
    }
}