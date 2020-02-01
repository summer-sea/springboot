package com.summer.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 注入问题
 * 加载book.properties 文件
 * 需要在每个属性上添加@Value注解
 * spring 提供的属性注入而springboot提供的是例行安全的属性注入
 * springboot 需要注解@ConfigurationProperties(prefix = "book")
 * 加上前缀 属性上则不需要@Value注解
 */

@Component
@PropertySource("classpath:book.properties")
@ConfigurationProperties(prefix = "book")
public class Book {

    private Long id;

    private String name;

    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
