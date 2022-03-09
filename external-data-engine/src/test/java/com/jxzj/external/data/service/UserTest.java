package com.jxzj.external.data.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jxzj.external.data.entity.users.User1;
import com.jxzj.external.data.entity.users.User2;
import com.jxzj.external.data.service.impl.User1ServiceImpl;
import com.jxzj.external.data.service.impl.User2ServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private User1ServiceImpl user1Service;

    @Autowired
    private User2ServiceImpl user2Service;

    @Test
    public void userText() throws Exception {
        User1 user1 = new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2 = new User2();
        user2.setName("李四");
        user2Service.addRequired(user2);

        throw new RuntimeException();
    }

}
