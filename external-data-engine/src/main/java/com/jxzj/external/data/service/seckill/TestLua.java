package com.jxzj.external.data.service.seckill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;

public class TestLua {

    private static final Logger logger = LoggerFactory.getLogger(TestLua.class);

    @Autowired
    private static RedisTemplate<String, String> redisTemplate;

    public static void main(String[] args) {

        String userid = "12306";
        String prodid = "sku123";

        String path = "seckill_redis_script.lua";
        ResourceScriptSource resourceScriptSource = new ResourceScriptSource(new ClassPathResource(path));

        DefaultRedisScript<Integer> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setScriptSource(resourceScriptSource);
        defaultRedisScript.setResultType(Integer.class);

        try {
            logger.info(resourceScriptSource.getScriptAsString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        List<String> keyList = new ArrayList<>();
        keyList.add(userid);
        keyList.add(prodid);

        Integer result = (Integer)redisTemplate.execute(defaultRedisScript, keyList, "100");
        logger.info("==============" + result);

    }

}
