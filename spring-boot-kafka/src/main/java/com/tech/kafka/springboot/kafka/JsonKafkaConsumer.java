package com.tech.kafka.springboot.kafka;

import com.tech.kafka.springboot.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "kafkaTopic2", groupId = "myGroup")
    private void consume(User user) {
        LOGGER.info("Json message received: {}", user);
    }
}
