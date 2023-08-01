package com.example.springsourcestudy.容器和上下文.工厂;

import com.example.springsourcestudy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class BeanFactoryTest {
    @Test
    void testHierarchicalBeanFactory(){
        //创建一个核心工厂
        DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();
        parentBeanFactory.registerSingleton("user", new User("单凤池",29));
        //创建一个子工厂
        DefaultListableBeanFactory childBeanFactory = new DefaultListableBeanFactory(parentBeanFactory);
        System.out.println(childBeanFactory.getBean("user"));
    }
}
