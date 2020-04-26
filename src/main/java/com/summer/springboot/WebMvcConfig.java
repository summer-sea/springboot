package com.summer.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-26 12:31
 * 注册拦截器
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截路径为 所有
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**");
    }

    @Bean
    MyInterceptor myInterceptor()
    {
        return new MyInterceptor();
    }
}
