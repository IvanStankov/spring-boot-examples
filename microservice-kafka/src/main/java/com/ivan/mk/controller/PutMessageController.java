package com.ivan.mk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutMessageController {
    private static final Logger logger = LoggerFactory.getLogger(PutMessageController.class);

    @Value("${spring.kafka.topic.messages}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    @PostMapping("/messages")
    public void putMessage(@RequestBody final Message message) {
        this.kafkaTemplate.send(this.topic, message);
    }

}
