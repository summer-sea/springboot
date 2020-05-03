package com.summer.springboot;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-05-02 19:18
 *
 * 可以自定义key
 **/
@Component
public class MyKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
       //返回值作为key
        return method.getName()+":"+ Arrays.toString(params);
    }
}
