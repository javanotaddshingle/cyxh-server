package com.example.ciyuanxingheserver.repository;

import com.example.ciyuanxingheserver.entity.LearningRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LearningRecordRepository extends JpaRepository<LearningRecord, Long> {
    List<LearningRecord> findByUserIdOrderByLastStudyTimeDesc(Long userId);
    Optional<LearningRecord> findByUserIdAndCourseId(Long userId, Long courseId);
}