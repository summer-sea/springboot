package com.summer.springboot.config;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

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
public class WebMvcConfig {

    /**
     * 通过json配置全局日期格式化
     * 可以通过ObjectMapper配置
     * @return
     */
    @Bean
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper om =new ObjectMapper();
        om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        converter.setObjectMapper(om);
        return converter;
    }

}
