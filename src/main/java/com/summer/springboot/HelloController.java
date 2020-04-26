package com.summer.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-26 12:35
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello()
    {
        return "hello interceptor";
    }
}
