package com.summer.springboot;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-24 17:21
 * springboot cors 跨域
 * 使用@CrossOrigin注解 添加origins=“www.。。。。”
 * 要接受的请求
 * 使用@CrossOrigin注解可以放在类上面或者放在方法上面
 *
 **/

@RestController
//@CrossOrigin(origins = "http://localhost:8081")
public class HelloController {

    @GetMapping("/hello")
    // 可以接受来自http://localhost:8081的请求
//    @CrossOrigin(origins = "http://localhost:8081")
    public String hello()
    {
        return "hello cors";
    }
}
