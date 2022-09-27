package com.example.chatdemo.services;

import com.example.chatdemo.model.ChatMessage;
import com.example.chatdemo.repos.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;


    @Autowired
    public ChatMessageService(ChatMessageRepository chatMessageRepository){
        this.chatMessageRepository = chatMessageRepository;
    }

    public List<ChatMessage> getMessages(){
        System.out.println(chatMessageRepository.findAll());
        return chatMessageRepository.findAll();
    }



    public void setMessage(ChatMessage chatMessage){
        chatMessageRepository.saveAndFlush(chatMessage);
    }

}
