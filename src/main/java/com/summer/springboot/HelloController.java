package com.summer.springboot;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;


@RestController
public class HelloController {



/**
*Description:将预设的全局数据在Model中取出
* @Param model
* @return: java.lang.String
* @Author: 大禹
* @Date: 2020/3/24
*/
    @GetMapping("/hello")
    public String hello(Model model)
    {
        //将model作为作为一个map取出其中的预设全局数据
        Map<String,Object> map = model.asMap();
        Set<String> keyset=map.keySet();
        for(String key:keyset)
        {
            System.out.println(key+":"+map.get(key));
        }
        return "hello";

    }
}
