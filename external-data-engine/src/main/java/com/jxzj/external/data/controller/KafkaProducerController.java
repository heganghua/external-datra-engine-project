package com.jxzj.external.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/kafka/normal/{message}")
    public void sendMessage(@PathVariable("message") String normalMessage) {
        System.out.println(normalMessage);
        kafkaTemplate.send("topic1", normalMessage);
    }
}
