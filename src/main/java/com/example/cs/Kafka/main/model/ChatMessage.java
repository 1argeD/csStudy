package com.example.cs.Kafka.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public record ChatMessage(
        @JsonProperty(value = "sender") String sender,
        @JsonProperty(value = "context") String context
) {

}
