package com.summer.springboot;

/**
 * @program: springboot
 * @author: 大禹
 * @create: 2020-03-24 08:18
 *
 * @ControllerAdvice 注解使用： 参数预处理演示类
 **/

public class Author {
    public String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
