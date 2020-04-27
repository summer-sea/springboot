package com.summer.springboot;

import com.summer.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-27 21:18
 **/
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/test1")
    public String getUserNameById(Integer id){
        return userService.getUserNameById(id);
    }
    @GetMapping("/test2")
    public void deleteUserById(Integer id)
    {
        userService.deleteUserById(id);
    }

}
