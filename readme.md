##### springboot自定义异常数据

###### 1.自定义错误页

 * 在static中自定义error文件夹注意必须是error文件夹其他文件夹不行
 * 在error文件夹中自定义错误页面比如500.html 404.html 等
 * 如果出现500的错误会直接调到500.html 的界面
 * 同事也支持模糊匹配规则 比如4xx.html 当发生404错误的时候会优先
 * 去找 404.html 如果找不到就会模糊匹配 4xx.html
 * 同样如果使用动态页面结果和静态页面类似
 * 优先级为想同条件下动态页面大于静态页面
 * 模糊匹配优先级最低

###### 2.自定义异常数据

* 继承 DefaultErrorAttributes类

* 重写DefaultErrorAttributes类中的getErrorAttributes方法
* 在页面上可以动态的展示出错误信息，
* 如果没有自定义错误信息将会展示默认DefaultErrorAttributes中的错误信息

MyErrorAttribute类

~~~java
package com.summer.springboot;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-04-24 10:48
 * 自定义异常数据 要重写 DefaultErrorAttributes类
 * 中的getErrorAttributes方法
 **/

@Component
public class MyErrorAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        //super将父类收集好的数据拿到map中在map基础上可以向添加或者移除
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("myerror","这是我自己定义的异常信息");
        return map;
    }
}

~~~

动态展示错误信息页面 500.html

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>templat es500</h1>
<table border="1">
    <tr>
        <td>path</td>
        <td th:text ="${path}"></td>
    </tr>
    <tr>
        <td>timestamp</td>
        <td th:text ="${timestamp}"></td>
    </tr>
    <tr>
        <td>message</td>
        <td th:text ="${message}"></td>
    </tr>
    <tr>
        <td>error</td>
        <td th:text ="${error}"></td>
    </tr>
    <tr>
        <td>status</td>
        <td th:text ="${status}"></td>
    </tr>
    <tr>
        <!--自定义的错误信息-->
        <td>myerror</td>
        <td th:text ="${myerror}"></td>
    </tr>
</table>

</body>
</html>
```
######  3.自定义异常视图

* 继承DefaultErrorViewResolver、

 * 重写resolveErrorView 方法
 * 创建视图页面将错误信息（model）返回到视图

MyErrorViewResolver类

```java
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
     * @param model 就是异常数据
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

```



javaError.html

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>javaerror-templat es500</h1>
<table border="1">
    <tr>
        <td>path</td>
        <td th:text ="${path}"></td>
    </tr>
    <tr>
        <td>timestamp</td>
        <td th:text ="${timestamp}"></td>
    </tr>
    <tr>
        <td>message</td>
        <td th:text ="${message}"></td>
    </tr>
    <tr>
        <td>error</td>
        <td th:text ="${error}"></td>
    </tr>
    <tr>
        <td>status</td>
        <td th:text ="${status}"></td>
    </tr>
    <tr>
        <!--自定义的错误信息-->
        <td>myerror</td>
        <td th:text ="${myerror}"></td>
    </tr>
</table>

</body>
</html>
```
