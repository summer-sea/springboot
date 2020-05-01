package com.summer.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-05-01 12:55
 *
 * springboot 整合redis
 * 引入了springSecurity
 * 注意项目启动的时候会给出默认 密码 用户名默认为user
 **/
@RestController
public class HelloController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/set")
    public void set(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("name","test1");

    }

    @GetMapping("/get")
    public void get(){

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String name = ops.get("name");
        System.out.println("name= "+name);
    }
}
