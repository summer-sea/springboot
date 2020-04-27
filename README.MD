#####  springboot 整合aop

###### 1.通过注解@Aspect 做切面类

* @Aspect 做切面类
*  @Pointcut 做拦截规则方法

```java
package com.summer.springboot;

import jdk.swing.interop.SwingInterOpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-27 21:25
 *  打印日志类
 *  将打印日志类做成一个切面了类
 * 注解@Aspect 表示 是一个切面
 *
 **/
@Component
@Aspect
public class LogComponent {
    //定义拦截规则
    // * com.summer.springboot.service.*.*(..) 表示
    // 任意返回值 (com.summer.springboot.service)包 . 任意类 .任意方法.(参数任意)
    @Pointcut("execution(* com.summer.springboot.service.*.*(..) )")
    public void pc1(){
    }

    //前置通知
    //注意pc1（）为设置的切面方法
    @Before(value = "pc1()")
    public void  before(JoinPoint jp){
        //拦截下来的方法
        String name =jp.getSignature().getName();
        System.out.println("before---"+name);
    }

    //后置通知
    @After(value = "pc1()")
    public void after(JoinPoint jp)
    {
        //拦截下来的方法
        String name =jp.getSignature().getName();
        System.out.println("after---"+name);
    }

    //返回通知
    @AfterReturning(value = "pc1()",returning = "result")
    public void afterReturning(JoinPoint jp,Object result){

        //拦截下来的方法
        String name =jp.getSignature().getName();
        System.out.println("afterReturning---"+name+" --result--"+result);

    }

    //异常通知
    @AfterThrowing(value = "pc1()",throwing = "e")
    public void afterThrowing(JoinPoint jp,Exception e){
        //拦截下来的方法
        String name =jp.getSignature().getName();
        System.out.println("afterThrowing---"+name+" --Exception--"+e.getMessage());
    }

    //环绕通知
    @Around("pc1()")
    public Object around(ProceedingJoinPoint pdj) throws Throwable {

        System.out.println("around 前");
        //当调用到proceed的时候方法才会继续执行 所以可以在 调用之前或之后做处理 相当于上面的四个
        Object proceed = pdj.proceed();
        System.out.println("around 后");
        return proceed;
    }
}

```

