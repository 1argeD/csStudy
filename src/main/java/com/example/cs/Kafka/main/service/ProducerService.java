package com.example.cs.Kafka.main.service;

import com.example.cs.Kafka.main.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private static final String TOPIC = "testTopic";
    private final KafkaTemplate<String, ChatMessage>kafkaTemplate;

    public void sendMessage(ChatMessage chatMessage) {
        System.out.println("chatMessage : " + chatMessage.context());

        kafkaTemplate.send(TOPIC, chatMessage);
    }

}
