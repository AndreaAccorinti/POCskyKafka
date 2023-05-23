package com.example.pocskykafka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    //KafkaTemplate encapsulates the producer logic and provides
    //convenient methods for sending messages to Kafka topics.
    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void saveMessageKafkaTail(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
