package com.redis.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2020/8/11
 */
@Configuration
public class LuaConfiguration {

    @Bean
    public DefaultRedisScript<Boolean> redisScript(){
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("script/add_distributed_lock.lua")));
        redisScript.setResultType(Boolean.class);
        return redisScript;
    }
}
