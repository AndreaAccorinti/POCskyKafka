package com.example.pocskykafka.components;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {
    @KafkaListener(topics = "ipUser", groupId = "myGroup")

    public void consume(String message) {
        System.out.println("Received message ipUser: " + message);
    }}
