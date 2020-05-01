package com.summer.springboot;

import com.summer.springboot.bean.Book;
import com.summer.springboot.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    BookDao bookDao;

    @Test
    void contextLoads() {
        Book book = new Book();
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        bookDao.save(book);
    }

    @Test
    public void update(){
        Book s = new Book();
        s.setAuthor("罗贯中");
        s.setName("三国演义");
        s.setId(1);
        bookDao.saveAndFlush(s);
    }

    @Test
    public void findbypage(){
        Pageable pageable = PageRequest.of(0,2);
        Page<Book> page = bookDao.findAll(pageable);
        System.out.println("总记录数 "+page.getTotalElements());
        System.out.println("是当前页记录数 "+page.getNumberOfElements());
        System.out.println("每页记录数 "+page.getSize());
        System.out.println("获取总页数 "+page.getTotalPages());
        System.out.println("每页记录数 "+page.getSize());
        System.out.println("查询结果 "+page.getContent());
        System.out.println("当前页 "+page.getNumber());
        System.out.println("是否为首页 "+page.isFirst());
    }

    @Test
    public void find1(){
        Book maxIdBook = bookDao.getMaxIdBook();
        System.out.println(" ::"+maxIdBook.toString());
    }

    @Test
    public void save1(){
        bookDao.addBook2("测试6","测试6");
    }

}
