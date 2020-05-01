package com.summer.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-05-01 13:50
 * springboot 做session共享
 * 引入spring session依赖后悔自动将session 放入redis 不需要做过多处理
 *
 **/
@RestController
public class HelloController {

    @Value("${server.port}")
    Integer port;

    @GetMapping("/set")
    public String  set(HttpSession httpSession){
        httpSession.setAttribute("name1","test1");

        return String.valueOf(port);
    }


    @GetMapping("/get")
    public  String get(HttpSession httpSession){

        return (String)httpSession.getAttribute("name1") + port;
    }
}
