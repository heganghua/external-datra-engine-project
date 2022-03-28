package com.jxzj.external.data.ioc;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@ConfigurationProperties(prefix = "spring")
@Component
public class IocDemo {

    @Autowired
    private Environment env;

    @Value("${spring.profiles.active}")
    private static String sp;

    @Value("${spring.redis.host}")
    private static String redis;

    public static void main(String[] args) throws Exception {

        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("log4j2.xml");

        System.out.println(System.getProperty("user.dir"));

        File file = ResourceUtils.getFile("classpath:config.xml");
        System.out.println(file.getPath());

        System.out.println(sp);
        System.out.println(redis);

    }

}
