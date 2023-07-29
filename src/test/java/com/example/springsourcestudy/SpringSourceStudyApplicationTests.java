package com.example.springsourcestudy;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringSourceStudyApplicationTests {
    Logger logger = LoggerFactory.getLogger(SpringSourceStudyApplicationTests.class);

    //BeanDefinition是Spring框架中定义Bean的配置元信息接口，它是Spring框架中定义Bean的配置元信息的接口，它是Spring框架中定义的最重要的接口之一。
    @Test
    public void testGenericBeanDefinition() {
        //GenericBeanDefinition是BeanDefinition的通用实现，它可以用来表示任何类型的BeanDefinition。
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClassName("com.example.pojo.User");
        beanDefinition.setScope("prototype");
        beanDefinition.setInitMethodName("init");
        beanDefinition.setDestroyMethodName("destroy");
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("name", "张三");
        propertyValues.addPropertyValue("age", 18);
        beanDefinition.setPropertyValues(propertyValues);
    }

    @Test
    public void testRootBeanDefinition() {
        //RootBeanDefinition是BeanDefinition的默认实现，它是Spring中最常用的BeanDefinition实现。
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName("com.example.pojo.Dog");
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("name", "旺财");
        propertyValues.addPropertyValue("color", "白色");
        beanDefinition.setPropertyValues(propertyValues);
        //ChildBeanDefinition是RootBeanDefinition的子类，它用于表示父BeanDefinition的信息。
        ChildBeanDefinition childBeanDefinition = new ChildBeanDefinition("dog");
        childBeanDefinition.setBeanClassName("com.example.pojo.TeddyDog");
        MutablePropertyValues childPropertyValues = new MutablePropertyValues();
        childPropertyValues.addPropertyValue("name", "小白");
        childPropertyValues.addPropertyValue("color", "黑色");
        childBeanDefinition.setPropertyValues(childPropertyValues);
    }

    @Test
    public void testBeanDefinitionRegistry() {
        //BeanDefinitionRegistry是BeanDefinition注册器，它是Spring中定义BeanDefinition的接口。
        //BeanDefinitionRegistry接口继承了AliasRegistry接口，它是Bean别名注册器，它用于管理Bean的别名。
        SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName("com.example.pojo.Dog");
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("name", "旺财");
        propertyValues.addPropertyValue("color", "白色");
        beanDefinition.setPropertyValues(propertyValues);
        registry.registerBeanDefinition("dog", beanDefinition);
        ChildBeanDefinition childBeanDefinition = new ChildBeanDefinition("dog");
        childBeanDefinition.setBeanClassName("com.example.pojo.TeddyDog");
        MutablePropertyValues childPropertyValues = new MutablePropertyValues();
        childPropertyValues.addPropertyValue("name", "小白");
        childPropertyValues.addPropertyValue("color", "黑色");
        childBeanDefinition.setPropertyValues(childPropertyValues);
        registry.registerBeanDefinition("teddyDog", childBeanDefinition);
        System.out.println(registry.getBeanDefinition("dog"));
    }

    @Test
    public void testBeanDefinitionRegistryByXml() {
        //BeanDefinitionRegistry接口的实现类之一是XmlBeanDefinitionReader，它是从XML文件中读取BeanDefinition的类。
        //XmlBeanDefinitionReader类的loadBeanDefinitions()方法用于从XML文件中读取BeanDefinition。
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions("classpath:bean.xml");
        System.out.println(registry.getBeanDefinition("dog").getBeanClassName());
    }

}
