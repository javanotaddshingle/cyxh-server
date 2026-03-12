package com.example.ciyuanxingheserver.repository;

import com.example.ciyuanxingheserver.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    List<Trade> findByCategory(String category);
    List<Trade> findByUserId(Long userId);
    List<Trade> findByTitleContaining(String title);
    List<Trade> findByStatus(String status);
}