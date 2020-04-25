package com.summer.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-25 22:23
 * 通过@ImportResource注解加载xml文件
 **/
@Configuration
@ImportResource(locations = "classpath:beans.xml")
public class WebMvcConfig {

}
