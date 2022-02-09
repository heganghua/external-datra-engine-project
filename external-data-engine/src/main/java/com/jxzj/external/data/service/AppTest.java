package com.jxzj.external.data.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext =
            new ClassPathXmlApplicationContext("classpath:application-local.yml");
        Object bean = classPathXmlApplicationContext.getBean("database");
        String string = new String();

    }

}
