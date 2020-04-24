package com.summer.springboot;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-24 10:48
 * 自定义异常数据 要重写 DefaultErrorAttributes类
 * 中的getErrorAttributes方法
 **/

@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        //super将父类收集好的数据拿到map中在map基础上可以向添加或者移除
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("myerror","这是我自己定义的异常信息");
        return map;
    }
}
