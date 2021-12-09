package com.jxzj.external.data.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.jxzj.external.data.aspacetdemo.Say;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsureQuotationTaskServiceText {

    private static final Logger logger = LoggerFactory.getLogger(InsureQuotationTaskServiceText.class);

    @Autowired
    private Say say;

    @Test
    public void text1() {
        say.sayHello("changsha");
    }

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void lua_test() throws Exception {

    }

    @Test
    public void test2() throws Exception {

        say.getStr("abcdefg");
    }

}
