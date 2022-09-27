package com.example.chatdemo.controller;

import com.example.chatdemo.model.ChatMessage;
import com.example.chatdemo.repos.ChatMessageRepository;
import com.example.chatdemo.services.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ChatMessageController {
    public final ChatMessageService chatMessageService;
    public final ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatMessageController(ChatMessageService chatMessageService, ChatMessageRepository chatMessageRepository){
        this.chatMessageService = chatMessageService;
        this.chatMessageRepository = chatMessageRepository;

    }

    @GetMapping("api/v1/get_chat_messages")
    public String getMessages(Model model){
        model.addAttribute("messages", chatMessageService.getMessages());
        return "messages";
    }

    @GetMapping("api/v1/get_all_messages")
    public List<ChatMessage> getMessagesObjects(){
        List<ChatMessage> messages = chatMessageService.getMessages();
        System.out.println("----------------------------------------------------------" + messages.size());
        return messages;
    }
/*
    @PostMapping("api/v1/set_chat_messages")
    public void getMessages(@ModelAttribute("message") ChatMessage chatMessage){
        chatMessageService.setMessage(chatMessage);
    }

 */
}
