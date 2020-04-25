###### 1.使用@CrossOrigin注解 添加origins=“www.。。。。”

* 使用@CrossOrigin注解 添加origins=“www.。。。。”要接受的请求地址

 * 使用@CrossOrigin注解可以放在类上面或者放在方法上面

   ```java
   package com.summer.springboot;
   
   import org.springframework.web.bind.annotation.CrossOrigin;
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.RestController;
   
   /**
    * @program: springboot
    * @author: 大禹
    * @create: 2020-04-24 17:21
    * springboot cors 跨域
    * 使用@CrossOrigin注解 添加origins=“www.。。。。”
    * 要接受的请求
    * 使用@CrossOrigin注解可以放在类上面或者放在方法上面
    *
    **/
   
   @RestController
   //@CrossOrigin(origins = "http://localhost:8081")
   public class HelloController {
   
       @GetMapping("/hello")
       // 可以接受来自http://localhost:8081的请求
       @CrossOrigin(origins = "http://localhost:8081")
       public String hello()
       {
           return "hello cors";
       }
   }
   
   ```

   



###### 2.第二种方法  通过实现WebMvcConfigurer接口 来进行全局配置

* springboot crors 解决跨域问题 全局配置
 * 通过实现WebMvcConfigurer接口
 * 复写addCorsMappings方法

```java
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
        .maxAge(30 * 1000); //探测请求的有效期


    }
}

```

