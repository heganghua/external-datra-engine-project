package com.jxzj.external.data.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    // 自定义topic
    public static final String TOPIC_TEST = "topic_test";

    public static final String TOPIC_GROUP1 = "topic_grup1";

    public static final String TOPIC_GROUP2 = "topic_grup2";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void send(Object obj) {
        LOGGER.info(obj.toString());
    }

}
