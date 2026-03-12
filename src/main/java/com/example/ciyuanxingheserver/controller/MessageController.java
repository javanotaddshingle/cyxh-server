package com.example.ciyuanxingheserver.controller;

import com.example.ciyuanxingheserver.entity.Message;
import com.example.ciyuanxingheserver.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }

    @GetMapping("/user/{userId}")
    public List<Message> getUserMessages(@PathVariable Long userId) {
        return messageService.getUserMessages(userId);
    }

    @GetMapping("/conversation")
    public List<Message> getConversation(@RequestParam Long userId1, @RequestParam Long userId2) {
        return messageService.getConversation(userId1, userId2);
    }

    @GetMapping("/user/{userId}/unread-count")
    public Map<String, Object> getUnreadCount(@PathVariable Long userId) {
        long count = messageService.getUnreadCount(userId);
        Map<String, Object> result = new HashMap<>();
        result.put("count", count);
        return result;
    }

    @PostMapping("/{id}/read")
    public Map<String, Object> markAsRead(@PathVariable Long id) {
        messageService.markAsRead(id);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        return result;
    }

    @PostMapping("/user/{userId}/read-all")
    public Map<String, Object> markAllAsRead(@PathVariable Long userId) {
        messageService.markAllAsRead(userId);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        return result;
    }
}