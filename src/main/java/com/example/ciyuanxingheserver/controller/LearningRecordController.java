package com.example.ciyuanxingheserver.controller;

import com.example.ciyuanxingheserver.entity.LearningRecord;
import com.example.ciyuanxingheserver.service.LearningRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/learning-records")
public class LearningRecordController {
    @Autowired
    private LearningRecordService learningRecordService;

    @PostMapping
    public LearningRecord createOrUpdateRecord(@RequestBody LearningRecord record) {
        return learningRecordService.createOrUpdateRecord(record);
    }

    @GetMapping("/user/{userId}")
    public List<LearningRecord> getUserLearningRecords(@PathVariable Long userId) {
        return learningRecordService.getUserLearningRecords(userId);
    }

    @GetMapping("/user/{userId}/course/{courseId}")
    public LearningRecord getUserCourseRecord(@PathVariable Long userId, @PathVariable Long courseId) {
        return learningRecordService.getUserCourseRecord(userId, courseId);
    }

    @PostMapping("/{id}/progress")
    public LearningRecord updateProgress(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        int progress = body.getOrDefault("progress", 0);
        return learningRecordService.updateProgress(id, progress);
    }
}