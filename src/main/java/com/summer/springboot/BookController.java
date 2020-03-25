package com.summer.springboot;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-03-24 08:19
 * ControllerAdvice注解 参数预处理
 **/
@RestController
public class BookController {

    /**
    * @Param book
    * @Param author
    * @return: void
    * @Author: 大禹
    * @Date: 2020/3/24
    *如果不做参数预处理传过来的Book和Author的name属性
    * 会出现问题，会合并在一块，因为无法区分是谁的name属性
    */
   @PostMapping("/book")
   //public void addBook(Book book,Author author)
   //做参数预处理
   //1.将参数起别名
   //2.正在ControllerAdvice中做InitBinder处理就是加上别名前缀
   //3.在前段页面进行传递参数的时候要加上别名a.name
   public void addBook(@ModelAttribute("b") Book book, @ModelAttribute("a")Author author)
   {
       //未做参数预处理时输出的内容 因为无法区分name属性
       //所以会把name合并
       //如：Book{name='三国,罗贯中', price=100.0}
       //如：Author{name='三国,罗贯中', age=60}
       System.out.println(book);
       System.out.println(author);

   }
}
