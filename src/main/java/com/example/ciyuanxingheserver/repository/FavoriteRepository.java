package com.example.ciyuanxingheserver.repository;

import com.example.ciyuanxingheserver.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUserId(Long userId);
    Optional<Favorite> findByUserIdAndWorkId(Long userId, Long workId);
    void deleteByUserIdAndWorkId(Long userId, Long workId);
}