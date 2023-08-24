package com.example.springsourcestudy.pojo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("UserFactoryBean")
public class UserFactoryBean implements FactoryBean<User> {
    // 它用于创建和配置对象，以及将它们添加到Spring容器中。
    // FactoryBean的主要作用是将对象的创建和配置逻辑封装起来，使得开发者可以以更高级别的抽象来定义和配置Bean。
    // 它允许你在创建Bean时执行一些自定义的逻辑，而不仅仅是简单地实例化一个对象。
    @Override
    public User getObject() throws Exception {
        //忽略复杂逻辑
        return new User("单凤池", 29);
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
