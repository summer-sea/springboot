package com.summer.springboot.exception;


import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 使用@ControllerAdvice 处理全局异常
 * 可以定义任意的异常
 *
 */
@ControllerAdvice
public class MyCustomException {

    //创建超出限定上传文件大小的异常 直接打印出错误信息
    /*@ExceptionHandler(MaxUploadSizeExceededException.class)
    public void myexception(MaxUploadSizeExceededException e,HttpServletResponse resp)throws IOException
    {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out =resp.getWriter();
        out.write("上传文件超出大小限制");
        out.flush();
        out.close();
    }*/


    //在templeate中创建myerror错误页
    //创建超出限定上传文件大小的异常返回一个modelandview视图
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView myexception(MaxUploadSizeExceededException e)
    {
        ModelAndView mav = new ModelAndView("myerror");
        mav.addObject("error","上传文件大小超出限制");
        return mav;

    }


}
