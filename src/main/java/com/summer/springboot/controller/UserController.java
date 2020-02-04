package com.summer.springboot.controller;

import com.summer.springboot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Json方案，springboot start包中自带json
 * 使用json 要加上@ResponseBody 注解
 * 也可是使用组合注解@RestController 就是@Controller和@ResponseBody
 * 的组合
 */
//@Controller
@RestController
public class UserController {

    //@ResponseBody
    @GetMapping("/user")
    public List<User> getllUser(){
        List<User> users =new ArrayList<>();
        for (int i=0;i<10;i++){
            User user =new User();
            user.setAddress("上海");
            user.setUsername("张三>>"+i);
            user.setId(i);
            user.setBirthday(new  Date());
            users.add(user);
        }

        return users;

    }

}
