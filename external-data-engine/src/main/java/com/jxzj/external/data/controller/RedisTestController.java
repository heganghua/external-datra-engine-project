package com.jxzj.external.data.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jxzj.external.data.dto.SecKillInfo;
import com.jxzj.external.data.service.seckill.ISecKillService;

@RestController
@RequestMapping("/seckill")
public class RedisTestController {

    @Autowired
    private RedisTemplate<String, Object> redistemplate;

    @Resource
    private DefaultRedisScript<Integer> redisScript;

    @Autowired
    private ISecKillService secKillService;

    @PostMapping("/doseckill")
    public Boolean doseckill(@RequestBody SecKillInfo request) {

        Boolean doSecKill = secKillService.doSecKill(request.getProdid());

        return doSecKill;
    }

    @PostMapping("/lua")
    public Boolean testLua() {
        List<String> keys = Arrays.asList("12306", "sku123");
        Integer execute = redistemplate.execute(redisScript, keys, "100");
        assert execute != null;
        return true;
    }

}
