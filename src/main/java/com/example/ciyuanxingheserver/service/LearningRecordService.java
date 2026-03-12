package com.example.ciyuanxingheserver.service;

import com.example.ciyuanxingheserver.entity.LearningRecord;
import com.example.ciyuanxingheserver.repository.LearningRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LearningRecordService {
    @Autowired
    private LearningRecordRepository learningRecordRepository;

    public LearningRecord createOrUpdateRecord(LearningRecord record) {
        Optional<LearningRecord> existingRecord = learningRecordRepository.findByUserIdAndCourseId(record.getUserId(), record.getCourseId());
        if (existingRecord.isPresent()) {
            LearningRecord existing = existingRecord.get();
            existing.setProgress(record.getProgress());
            existing.setLastStudyTime(new Date());
            return learningRecordRepository.save(existing);
        } else {
            record.setCreatedAt(new Date());
            record.setLastStudyTime(new Date());
            return learningRecordRepository.save(record);
        }
    }

    public List<LearningRecord> getUserLearningRecords(Long userId) {
        return learningRecordRepository.findByUserIdOrderByLastStudyTimeDesc(userId);
    }

    public LearningRecord getUserCourseRecord(Long userId, Long courseId) {
        return learningRecordRepository.findByUserIdAndCourseId(userId, courseId).orElse(null);
    }

    public LearningRecord updateProgress(Long recordId, int progress) {
        LearningRecord record = learningRecordRepository.findById(recordId).orElse(null);
        if (record != null) {
            record.setProgress(progress);
            record.setLastStudyTime(new Date());
            return learningRecordRepository.save(record);
        }
        return null;
    }
}