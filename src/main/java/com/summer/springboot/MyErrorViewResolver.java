package com.summer.springboot;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.DefaultErrorViewResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-24 11:27
 * 自定义异常视图 继承DefaultErrorViewResolver、
 * 重写resolveErrorView 方法
 * 创建视图页面将错误信息（model）返回到视图
 **/
@Component
public class MyErrorViewResolver extends DefaultErrorViewResolver {

    /**
     * Create a new {@link DefaultErrorViewResolver} instance.
     *
     * @param applicationContext the source application context
     * @param resourceProperties resource properties
     */
    public MyErrorViewResolver(ApplicationContext applicationContext, ResourceProperties resourceProperties) {
        super(applicationContext, resourceProperties);
    }


    /**
     * @param request
     * @param status
     * @param model 就是异常数据 注意这个model是map不可以被修改
     *              如果要修改要自己定义一个map将model中需要的的内容放入新map
     *              后做返回
     * @return
     */
    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        ModelAndView mv = new ModelAndView();
        //视图的名字就是放在templates下的页面的名字
        mv.setViewName("javaError");
        mv.addAllObjects(model);
        return mv;
    }
}
