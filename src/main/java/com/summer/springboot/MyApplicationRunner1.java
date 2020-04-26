package com.summer.springboot;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-26 13:47
 * srpingboot 实现系统自启动任务
 * 通过实现ApplicationRunner接口
 * 如果有多个可以通过 @Order注解来定义优先级
 * 注意order数字越大级别越低
 **/
@Component
@Order(99)
public class MyApplicationRunner1 implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //获取启动的所有参数
        String[] sourceArgs = args.getSourceArgs();
        System.out.println("sourceArgs>> "+ Arrays.toString(sourceArgs));
        //没有key 的参数相当于数组
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("nonOptionArgs "+nonOptionArgs);
        //key -value形式的参数
        Set<String> optionNames = args.getOptionNames();
        System.out.println(">>>>>>>>>>>>>>>>");
        for(String optionName:optionNames)
        {
            System.out.println(optionName+":"+args.getOptionValues(optionName));
        }
        System.out.println(">>>>>>MyApplicationRunner1结束>>>>>>>");

    }
}
