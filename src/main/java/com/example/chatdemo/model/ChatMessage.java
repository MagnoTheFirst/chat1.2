package com.example.chatdemo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class ChatMessage {


    @Id
    @SequenceGenerator
            (
                    name="message_sequence",
                    sequenceName = "message_sequence",
                    allocationSize = 1
            )
    @GeneratedValue
            (
                    strategy = GenerationType.SEQUENCE,
                    generator = "message_sequence"
            )
    private Long id;
    private String content;
    private String sender;
    private MessageType type;

    private LocalDateTime dateTime;

    public enum MessageType {
        CHAT, LEAVE, JOIN
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public Long getId(){return id;}

    public LocalDateTime getLocalDateTime(){
        return this.dateTime;
    }


}