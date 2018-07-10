package com.ivan.mkc.listener;

import com.ivan.mkc.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @KafkaListener(topics = "${spring.kafka.topic.messages}", groupId = "123")
    public void listen(final Message message) {
        logger.info("Received a message!!!!!!!! {}", message);
    }

}
