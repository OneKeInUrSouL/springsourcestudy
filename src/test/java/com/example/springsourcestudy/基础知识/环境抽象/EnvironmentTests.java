package com.example.springsourcestudy.基础知识.环境抽象;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.StandardEnvironment;

import java.util.Properties;

public class EnvironmentTests {
    //profile是一个给定名字的逻辑分组的beanDefinition集合，只有处于激活状态的profile中的beanDefinition才会被注册到IoC容器中。
    //properties在几乎所有的情况下都是以键值对的形式存在的，它们可以通过Environment对象来访问。他的来源有多种，包括操作系统环境变量、JVM系统属性、JNDI、servlet上下文参数、属性文件、Map对象等。
    @Test
    public void testMoreEnvProperties(){
        ApplicationContext applicationContext = new GenericApplicationContext();
        Environment environment = applicationContext.getEnvironment();
        System.out.println(environment.getProperty("os.name"));
    }

    @Test
    public void testStandardEnvironment(){
        StandardEnvironment environment = new StandardEnvironment();
        Properties properties = new Properties();
        properties.setProperty("age","100");
        environment.getPropertySources().addLast(new PropertiesPropertySource("myProperties",properties));
        System.out.println(environment.getProperty("age"));
    }
}
