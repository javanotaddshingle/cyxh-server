package com.example.ciyuanxingheserver.controller;

import com.example.ciyuanxingheserver.entity.Work;
import com.example.ciyuanxingheserver.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/works")
public class WorkController {
    @Autowired
    private WorkService workService;

    @PostMapping
    public Work createWork(@RequestBody Work work) {
        return workService.createWork(work);
    }

    @GetMapping
    public List<Work> getAllWorks() {
        return workService.getAllWorks();
    }

    @GetMapping("/{id}")
    public Work getWorkById(@PathVariable Long id) {
        // 增加阅读量
        workService.incrementViews(id);
        return workService.getWorkById(id);
    }

    @GetMapping("/category/{category}")
    public List<Work> getWorksByCategory(@PathVariable String category) {
        return workService.getWorksByCategory(category);
    }

    @GetMapping("/user/{userId}")
    public List<Work> getWorksByUserId(@PathVariable Long userId) {
        return workService.getWorksByUserId(userId);
    }

    @GetMapping("/search/{keyword}")
    public List<Work> searchWorks(@PathVariable String keyword) {
        return workService.searchWorks(keyword);
    }

    @PutMapping("/{id}")
    public Work updateWork(@PathVariable Long id, @RequestBody Work work) {
        work.setId(id);
        return workService.updateWork(work);
    }

    @DeleteMapping("/{id}")
    public void deleteWork(@PathVariable Long id) {
        workService.deleteWork(id);
    }

    @PostMapping("/{id}/like")
    public Map<String, Object> likeWork(@PathVariable Long id, @RequestParam Long userId) {
        Work work = workService.likeWork(id);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("likes", work.getLikes());
        result.put("message", "点赞成功");
        return result;
    }

    @PostMapping("/{id}/favorite")
    public Map<String, Object> favoriteWork(@PathVariable Long id, @RequestParam Long userId) {
        boolean isFavorited = workService.favoriteWork(id, userId);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("isFavorited", isFavorited);
        result.put("message", isFavorited ? "收藏成功" : "取消收藏");
        return result;
    }

    @GetMapping("/{id}/isFavorited")
    public Map<String, Object> isWorkFavorited(@PathVariable Long id, @RequestParam Long userId) {
        boolean isFavorited = workService.isWorkFavorited(id, userId);
        Map<String, Object> result = new HashMap<>();
        result.put("isFavorited", isFavorited);
        return result;
    }

    @GetMapping("/user/{userId}/favorites")
    public List<Work> getUserFavoriteWorks(@PathVariable Long userId) {
        return workService.getUserFavoriteWorks(userId);
    }

    @GetMapping("/ranking")
    public List<Work> getWorkRanking(@RequestParam(defaultValue = "likes") String type) {
        return workService.getWorkRanking(type);
    }
}