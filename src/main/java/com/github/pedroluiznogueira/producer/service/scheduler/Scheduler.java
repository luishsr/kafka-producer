package com.github.pedroluiznogueira.producer.service.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Scheduler {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private Integer count = 0;

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        count++;
        kafkaTemplate.send("t.scheduled", "message " + count);
        System.out.println("sent message count " + count);
    }

}