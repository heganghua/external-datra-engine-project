package com.jxzj.external.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private ISecKillService secKillService;

    @PostMapping("/doseckill")
    public Boolean doseckill(@RequestBody SecKillInfo request) {

        Boolean doSecKill = secKillService.doSecKill(request.getProdid());

        return doSecKill;

    }

}
