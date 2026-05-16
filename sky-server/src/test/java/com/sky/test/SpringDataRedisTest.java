package com.sky.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class SpringDataRedisTest {

    @Autowired
    private RedisTemplate redisTemplate;


//    public void testRedis() {
//        System.out.println(redisTemplate);
//    }
    @Test
    public void testRedis() {
        redisTemplate.opsForValue().set("name", "zhangsan");
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    /**
     * 测试Redis字符串数据
     */
    @Test
    public void testString() {
         redisTemplate.opsForValue().set("name", "zhangsan");
         Object name = redisTemplate.opsForValue().get("name");
         System.out.println(name);
         redisTemplate.opsForValue().set("code", "12345678",60, TimeUnit.SECONDS);
         redisTemplate.opsForValue().setIfAbsent("lock", "1");
         redisTemplate.opsForValue().setIfAbsent("lock", "2");
    }

}
