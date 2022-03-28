package com.jxzj.external.data.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {

    @Bean
    public Tom tom() {
        Tom tom = new Tom();
        tom.setColor("123");
        tom.setName("lucy");
        return tom;
    }

}
