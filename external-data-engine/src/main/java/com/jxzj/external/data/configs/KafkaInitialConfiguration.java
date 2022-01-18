package com.jxzj.external.data.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaInitialConfiguration {

    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("testtopic", 8, (short)2);
    }

    public NewTopic updateTopic() {
        return new NewTopic("testtopic", 10, (short)2);
    }
}