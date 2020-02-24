package com.summer.springboot.config;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;

/**
 * @Author:chiyou
 * Project Name: springboot
 * File Name: WebMvcConfig
 * Package Name: com.summer.springboot.config
 * Date: 2020/2/4 11:45
 *配置类
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 通过json配置全局日期格式化
     * 可以通过ObjectMapper配置
     * @return
     */
    @Bean
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper om = new ObjectMapper();
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        converter.setObjectMapper(om);
        return converter;
    }

    /**
     * 在pom文件中取出springboot自带的json 加上fastjson依赖
     * FastJson 配置使用fastjson必须要配置
     *
     * @return
     */
    /*
    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter converter1 =new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig =new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy-MM-dd");
            return converter1;
        }
*/

    /**
     * 配置静态资源位置
     *重写 源码中 的addResourceHandlers 方法
     * addResourceLocations参数是数组可以添加一个或多个路径
     */
   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations("classpath:/summ/","classpath:/static/");
    }*/
}


