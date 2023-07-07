package com.example.cs.Kafka.main.service;

import com.example.cs.Kafka.main.model.ChatMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(topics = "testTopic", groupId = "testTopic", containerFactory = "kafkaListener")
    public void consume(ChatMessage message) {
        System.out.println("name : "+ message.sender());
        System.out.println("consume message : "+ message.context());
    }
}
