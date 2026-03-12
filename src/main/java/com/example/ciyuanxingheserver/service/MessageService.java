package com.example.ciyuanxingheserver.service;

import com.example.ciyuanxingheserver.entity.Message;
import com.example.ciyuanxingheserver.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message sendMessage(Message message) {
        message.setCreatedAt(new Date());
        message.setRead(false);
        return messageRepository.save(message);
    }

    public List<Message> getUserMessages(Long userId) {
        return messageRepository.findByToUserIdOrderByCreatedAtDesc(userId);
    }

    public List<Message> getConversation(Long userId1, Long userId2) {
        return messageRepository.findByFromUserIdAndToUserIdOrFromUserIdAndToUserIdOrderByCreatedAtAsc(
                userId1, userId2, userId2, userId1);
    }

    public long getUnreadCount(Long userId) {
        return messageRepository.countByToUserIdAndIsReadFalse(userId);
    }

    public void markAsRead(Long messageId) {
        Message message = messageRepository.findById(messageId).orElse(null);
        if (message != null) {
            message.setRead(true);
            messageRepository.save(message);
        }
    }

    public void markAllAsRead(Long userId) {
        List<Message> messages = messageRepository.findByToUserIdOrderByCreatedAtDesc(userId);
        for (Message message : messages) {
            if (!message.isRead()) {
                message.setRead(true);
                messageRepository.save(message);
            }
        }
    }
}