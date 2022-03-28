package com.jxzj.external.data.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jxzj.external.data.service.impl.User1ServiceImpl;
import com.jxzj.external.data.service.impl.User2ServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Value("${spring.profiles.active}")
    private static String sp;

    @Value("${spring.redis.host}")
    private static String redis;

    @Autowired
    private User1ServiceImpl user1Service;

    @Autowired
    private User2ServiceImpl user2Service;

    @Test
    public void userText() throws Exception {

        System.out.println(sp);
        System.out.println(redis);

        // User1 user1 = new User1();
        // user1.setName("张三");
        // user1Service.addRequired(user1);
        //
        // User2 user2 = new User2();
        // user2.setName("李四");
        // user2Service.addRequired(user2);
        //
        // throw new RuntimeException();
    }

}
