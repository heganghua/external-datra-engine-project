package com.jxzj.external.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RedisTestController {

    @Autowired
    private RedisTemplate<String, Object> redistemplate;

    @GetMapping("/redis/{kind}")
    public String redisTest(@PathVariable("kind") String kind) {
        redistemplate.opsForValue().set("name", "lucy");
        redistemplate.opsForValue().set("sex", "woman");

        String object = (String)redistemplate.opsForValue().get(kind);
        return object;

    }

}
