package com.summer.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-19 22:14
 * 自定义错误页面
 * 在static中自定义error文件夹注意必须是error文件夹其他文件夹不行
 * 在error文件夹中自定义错误页面比如500.html 404.html 等
 * 如果出现500的错误会直接调到500.html 的界面
 * 同事也支持模糊匹配规则 比如4xx.html 当发生404错误的时候会优先
 * 去找 404.html 如果找不到就会模糊匹配 4xx.html
 * 同样如果使用动态页面结果和静态页面类似
 * 优先级为想同条件下动态页面大于静态页面
 * 模糊匹配为优先级最低
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello()
    {
        int i=1/0;
        return "hello";
    }
}
