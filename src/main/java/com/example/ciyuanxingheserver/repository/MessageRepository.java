package com.example.ciyuanxingheserver.repository;

import com.example.ciyuanxingheserver.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByToUserIdOrderByCreatedAtDesc(Long toUserId);
    List<Message> findByFromUserIdAndToUserIdOrFromUserIdAndToUserIdOrderByCreatedAtAsc(
            Long fromUserId1, Long toUserId1, Long fromUserId2, Long toUserId2);
    long countByToUserIdAndIsReadFalse(Long toUserId);
}