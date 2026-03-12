package com.example.ciyuanxingheserver.repository;

import com.example.ciyuanxingheserver.entity.Drawing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrawingRepository extends JpaRepository<Drawing, Long> {
    List<Drawing> findByUserIdOrderByCreatedAtDesc(Long userId);
    List<Drawing> findByCategoryOrderByCreatedAtDesc(String category);
}