package com.example.ciyuanxingheserver.repository;

import com.example.ciyuanxingheserver.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
    List<Workshop> findByCategory(String category);
    List<Workshop> findByUserId(Long userId);
    List<Workshop> findByTitleContaining(String title);
}