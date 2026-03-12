package com.example.ciyuanxingheserver.repository;

import com.example.ciyuanxingheserver.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByLanguage(String language);
    List<Course> findByUserId(Long userId);
    List<Course> findByTitleContaining(String title);
}