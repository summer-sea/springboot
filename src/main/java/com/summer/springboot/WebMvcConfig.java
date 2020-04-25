package com.summer.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-25 21:49
 * springboot crors 解决跨域问题 全局配置
 * 通过实现WebMvcConfigurer接口
 * 复写addCorsMappings方法
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许所有接口
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081") //接受的请求地址
        .allowedHeaders("*") //接受的所有的请求头
        .allowedMethods("*") //所有的方法
        .maxAge(30 * 1000); //put请求的探测请求的有效期


    }
}
