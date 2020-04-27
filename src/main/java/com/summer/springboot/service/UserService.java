package com.summer.springboot.service;

import org.springframework.stereotype.Service;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-27 21:16
 **/
@Service
public class UserService {
    public String getUserNameById(Integer id){
        System.out.println("getUserNameById");
        return "java-service";
    }
    public void deleteUserById(Integer id)
    {
        System.out.println("deleteUserById");
    }
}
