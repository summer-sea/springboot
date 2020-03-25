package com.summer.springboot;


import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @ControllerAdvice
 * 预设全局数据
 * 定义全局数据在任何controller中都可以访问到
 * @ControllerAdvice 配合 @ModelAttribute 预设全局数据
 * 实际上这个注解的作用就是，允许你往 Model 中注入全局属性
 * （可以供所有Controller中注有@Request Mapping的方法使用）
 * ，value 和 name 用于指定 属性的 key ，
 *
 *
 */
/** 
* @Param null 
* @return:  
* @Author: 大禹
* @Date: 2020/3/24 
*
*
*/ 

@ControllerAdvice
public class GlobaData {

    //在任controller都可以使用
    //实际上获取到的就是个Map info就是key返回值就是value
    //实际上是注入到Model中
    //使用时要拿到model然后取出model中对应的key（这里是info）
    @ModelAttribute(value = "info")
    public Map<String,Object> mydata()
    {
        Map<String,Object> map= new HashMap<>();
        map.put("name","dayu");
        map.put("age",18);
        return map;
    }

    /**
    * @Param binder
    * @return: void
    * @Author: 大禹
    * @Date: 2020/3/24
    *参数预处理 将参数做别名预处理
    *在前端接口冲传递参数时要加上别名a.name
    */
    @InitBinder("a")
    public void initA(WebDataBinder binder)
    {
        //将binder设置前缀
        binder.setFieldDefaultPrefix("a.");

    }
    /**
    * @Param binder
    * @return: void
    * @Author: 大禹
    * @Date: 2020/3/24
    *参数预处理 将参数做别名预处理
    *前端接口冲传递参数时要加上别名a.name
    */
    @InitBinder("b")
    public void initB(WebDataBinder binder)
    {
        //将binder设置前缀
        binder.setFieldDefaultPrefix("b.");

    }
}
