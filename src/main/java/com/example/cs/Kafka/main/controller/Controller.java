package com.example.cs.Kafka.main.controller;

import com.example.cs.Kafka.main.config.KafkaProducerConfig;
import com.example.cs.Kafka.main.model.ChatMessage;
import com.example.cs.Kafka.main.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ProducerService service;

    @PostMapping("kafka")
    public String sendMessage(@RequestBody ChatMessage message) {
        System.out.println("text : " + message);
        service.sendMessage(message);
    return "success";
    }
}
