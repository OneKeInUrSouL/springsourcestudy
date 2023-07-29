package com.example.springsourcestudy.Spring反射工具;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.ResolvableType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanWrapperTest {
    private Map<String, List<String>> map=new HashMap<>();
    Logger logger= LoggerFactory.getLogger(BeanWrapperTest.class);
    @Test
    void beanWrapperTest() throws ClassNotFoundException {
        //1.创建类信息，并给属性赋值
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClassName("com.example.springsourcestudy.pojo.User");
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue(new PropertyValue("name", "张三"));
        mutablePropertyValues.addPropertyValue(new PropertyValue("age", 18));
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
        //2.通过BeanWrapper进行实例化
        Class clazz = Class.forName(genericBeanDefinition.getBeanClassName());
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(clazz);
        beanWrapper.setPropertyValues(genericBeanDefinition.getPropertyValues());
        Object wrappedInstance = beanWrapper.getWrappedInstance();
        logger.info(() -> wrappedInstance.toString());
    }

    /**
     * 类型解析工具测试
     */
    @Test
    void resolvableTypeTest() throws NoSuchFieldException {
        //获取已经声明的类型
        ResolvableType resolvableType = ResolvableType.forField(getClass().getDeclaredField("map"));
        resolvableType.getSuperType();
        resolvableType.asMap();
        resolvableType.getGeneric(0);
        resolvableType.getGeneric(1);
        System.out.println(Arrays.toString(resolvableType.getGenerics()));
    }

}
