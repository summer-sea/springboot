package com.summer.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {


    @Autowired
    SayHello sayHello;

    @Test
    void contextLoads() {
        System.out.println(sayHello.sayHello());
    }

}
