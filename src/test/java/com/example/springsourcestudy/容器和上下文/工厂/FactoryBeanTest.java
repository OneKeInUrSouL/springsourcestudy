package com.example.springsourcestudy.容器和上下文.工厂;

import com.example.springsourcestudy.javaBean.UserFactoryBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FactoryBeanTest {
    @Autowired
    UserFactoryBean userFactoryBean;
    @Autowired
    BeanFactory beanFactory;

    /**
     * 工厂bean测试
     *
     * @throws Exception 异常
     */
    @Test
    void MyFactoryBeanTest() throws Exception {
        //获取实例
        Object user = beanFactory.getBean("UserFactoryBean");
        Object userFactory = beanFactory.getBean("&UserFactoryBean");
        System.out.println(user.toString());
        System.out.println(userFactory.toString());
    }
}
