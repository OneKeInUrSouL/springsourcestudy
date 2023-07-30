package com.example.springsourcestudy.tool.Spring反射工具;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.ResolvableType;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanWrapperTest {
    Logger logger = LoggerFactory.getLogger(BeanWrapperTest.class);
    private Map<String, List<String>> map = new HashMap<>();

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
     * 批处理xml bean实例测试
     *
     * @throws ClassNotFoundException 类没有发现异常
     */
    @Test
    void batchInstanceByXmlBeanTest() throws ClassNotFoundException {
        //1.获取xml中的beanDefinition 并对其进行实例化
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions("classpath:bean.xml");
        for (String beanDefinitionName : registry.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = registry.getBeanDefinition(beanDefinitionName);
            //1.1 通过自定义的类型转换器进行类型转换
            DefaultConversionService conversionService = new DefaultConversionService();
            conversionService.addConverter(new StringToIntegerConverter());
            conversionService.addConverter(new stringToStringConver());
            //1.2 使用beanWrapper进行实例化
            BeanWrapper beanWrapper = new BeanWrapperImpl(Class.forName(beanDefinition.getBeanClassName()));
            beanWrapper.setConversionService(conversionService);
            beanWrapper.setPropertyValues(beanDefinition.getPropertyValues());
            Object bean = beanWrapper.getWrappedInstance();
            logger.info(bean::toString);
        }
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
