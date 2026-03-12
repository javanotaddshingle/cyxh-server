package com.example.ciyuanxingheserver.repository;

import com.example.ciyuanxingheserver.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {
    List<Work> findByCategory(String category);
    List<Work> findByUserId(Long userId);
    List<Work> findByTitleContaining(String title);
}