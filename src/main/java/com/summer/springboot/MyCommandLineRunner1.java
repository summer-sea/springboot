package com.summer.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import java.util.Arrays;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-26 12:48
 * springboot 实现系统自动任务
 * 通过实现CommandLineRunner接口
 * 如果有多个可以通过@Order注解来进行优先级
 * 注意order（99） 数字越大优先级越低
 **/

@Component
@Order(100)
public class MyCommandLineRunner1 implements CommandLineRunner {

    //要启动时启动的args 是来自
    // SpringApplication.run(SpringbootApplication.class, args)中的args
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner1 >>> "+ Arrays.toString(args));

    }
}
