package com.example.chatdemo.repos;

import com.example.chatdemo.model.ChatMessage;
import com.example.chatdemo.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

}
