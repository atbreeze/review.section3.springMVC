package com.cryptossu.review.section3.springMVC.hello_world;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService (MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    public Message creageMessage(Message message) {
        return messageRepository.save(message);
    }

}
