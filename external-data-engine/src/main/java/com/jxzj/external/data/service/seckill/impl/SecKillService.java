package com.jxzj.external.data.service.seckill.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import com.jxzj.external.data.service.seckill.ISecKillService;

@Service
public class SecKillService implements ISecKillService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Resource
    private DefaultRedisScript<Long> redisScript;

    @Override
    public Boolean doSecKill(String prodId) {

        String uId = new Random().nextInt(50000) + "";

        if (null == uId || prodId == null) {
            System.out.println("商品Id或者用户ID错误。。。。");
            return false;
        }
        String kcKey = "sk:" + prodId + ":qt";
        String userKey = "sk:" + prodId + ":user";

        List<String> keys = Arrays.asList(uId, prodId);
        Long execute = redisTemplate.execute(redisScript, keys, "100");
        System.out.println(execute);
        return true;
        // System.out.println("kcKey " + kcKey + " userKey: " + userKey);
        // 4、判断库存是否
        // redisTemplate.watch(kcKey);
        // if (!redisTemplate.hasKey(kcKey)) {
        // System.out.println("商品不存在。。。");
        // return false;
        // }
        // String kc = redisTemplate.opsForValue().get(kcKey).toString();
        // if (kc == null) {
        // System.out.println("秒杀还没有开始。。。。");
        // return false;
        // }
        //
        // // 5、判断用户是否重复秒杀
        // Boolean member = redisTemplate.opsForSet().isMember(userKey, uId);
        // if (member) {
        // System.out.println("该用户已经秒杀成功，不能重复秒杀" + uId);
        // return false;
        // }
        //
        // // 6、判断库存是否少于1
        // if (Integer.parseInt(kc) <= 0) {
        // System.out.println("秒杀结束。。。。");
        // return false;
        // }
        //
        // // 开始事务队列
        // redisTemplate.multi();
        // redisTemplate.opsForValue().increment(kcKey, -1);
        // // 7.2添加用户进redis
        // redisTemplate.opsForSet().add(userKey, uId);
        // List<Object> exec = redisTemplate.exec();
        // if (null == exec || exec.size() == 0) {
        // System.out.println("秒杀失败！！！");
        // return false;
        // }
        // System.out.println("恭喜你，秒杀成功！！！！！");
        // exec.stream().forEach(System.out::println);
        // return true;
    }
}
