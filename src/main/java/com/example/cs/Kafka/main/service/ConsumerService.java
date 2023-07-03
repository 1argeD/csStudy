package com.example.cs.Kafka.main.service;

import com.example.cs.Kafka.main.model.ChatMessage;
import org.springframework.kafka.annotation.KafkaListener;

@org.springframework.stereotype.Service
public class ConsumerService {
    @KafkaListener(topics = "testRopic", groupId = "testGroup", containerFactory = "kafkaListener")
    public void consume(ChatMessage message) {
        System.out.println("name : "+ message.getSender());
        System.out.println("consume message + "+ message.getContext());
    }
}
