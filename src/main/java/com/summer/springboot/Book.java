package com.summer.springboot;

/**
 * @program: springboot
 * @description:
 * @author: 大禹
 * @create: 2020-03-24 08:14
 *
 * Book对象 controllerAdvice 参数预处理演示类
 **/

public class Book {
    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
