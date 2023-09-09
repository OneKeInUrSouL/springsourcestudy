package com.example.springsourcestudy.扩展;

import com.example.springsourcestudy.before.MyBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Proxy {
    @Autowired
    MyBean myBean;
    @Test
    public void testProxy() {
        System.out.println(myBean.getTitle());
    }
}
