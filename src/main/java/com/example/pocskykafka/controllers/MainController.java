package com.example.pocskykafka.controllers;

import com.example.pocskykafka.model.SkyUser;
import com.example.pocskykafka.services.KafkaProducerService;
import com.example.pocskykafka.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/saveMessageKafkaTail")
    public void saveMessageKafkaTail(@RequestBody SkyUser skyUser) {
        System.out.println(skyUser.getIp());
        try {
            kafkaProducerService.saveMessageKafkaTail(Constants.TOPIC_NAME, skyUser.getIp());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
