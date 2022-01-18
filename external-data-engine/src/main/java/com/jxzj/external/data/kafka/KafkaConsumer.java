package com.jxzj.external.data.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "topic1")
    public void onMessage1(ConsumerRecord<?, ?> record) {

    }
}
