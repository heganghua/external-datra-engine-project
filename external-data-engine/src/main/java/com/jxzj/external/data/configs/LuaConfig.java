package com.jxzj.external.data.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

@Configuration
public class LuaConfig {

    @Bean
    public DefaultRedisScript<Long> redisScript() {

        DefaultRedisScript<Long> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("seckill_redis_script.lua")));
        defaultRedisScript.setResultType(Long.class);
        return defaultRedisScript;
    }

}
