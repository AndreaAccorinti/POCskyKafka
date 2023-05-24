package com.example.pocskykafka.components;

import com.example.pocskykafka.model.SkyUser;
import com.example.pocskykafka.utils.Constants;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class KafkaConsumerService {
    @KafkaListener(topics = Constants.TOPIC_NAME, groupId = Constants.GROUP_ID)
    public void consume(String message) {

        RestTemplate restTemplate = new RestTemplate();
        SkyUser skyUser = restTemplate.getForObject("https://ipinfo.io/" +
                message + "/json", SkyUser.class);
        if (skyUser != null && !Objects.equals(skyUser.getCountry(), "IT")) {
            System.out.println("You're not in Italy");
        }else {
            System.out.println("You're in Italy");
        }
    }
    @KafkaListener(topics = Constants.TOPIC_NAME, groupId = Constants.GROUP_ID)
    public void readKafkaTail(ConsumerRecord<String, String> record) {
        // Process the received message
        String key = record.key();
        String value = record.value();
        System.out.println("Received message - Key: " + key + ", Value: " + value);
    }
    public SkyUser readKafkaTail(SkyUser skyUser) {
        return skyUser;
    }
}
