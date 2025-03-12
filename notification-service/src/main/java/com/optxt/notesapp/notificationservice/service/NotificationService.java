package com.optxt.notesapp.notificationservice.service;

import com.optxt.notesapp.notificationservice.dto.Note;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    Logger logger = LoggerFactory.getLogger(NotificationService.class.getName());

    @KafkaListener(topics = "notes", groupId = "notification-group")
    public void consume(ConsumerRecord<String,String> record) {

        logger.info("Received note: {}", record.value());

    }

}
