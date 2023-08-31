package com.example.springsourcestudy.基础知识.tool.内省api;

import com.example.springsourcestudy.pojo.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class BeanToolTest {
    Logger logger = LoggerFactory.getLogger(BeanToolTest.class);
    // 内省api是Java语言对JavaBean类属性、事件的一种缺省处理方法。
    // 例如类A中有属性name,那我们可以通过getName,setName来得到其值或者设置新的值。通过getName/setName来访问name属性，这就是默认的规则。
    // Java中提供了一套API用来访问某个属性的getter/setter方法，这套API被称为内省(Introspector)。
    // 内省包含了两个方面的内容：一个是类内省，一个是BeanInfo。
    // 类内省是指对一个类进行分析，了解其属性、方法、事件等的API，这些API都封装在java.beans.Introspector类中。
    // BeanInfo是对一个或多个属性、事件、方法的描述，这些描述信息都封装在java.beans.BeanInfo类中。

    //Javabean是一种特殊的类，它主要用于传递数据信息，这种类中的属性必须私有，通过getter/setter方法来访问，这种类中不包含业务逻辑,例如pojo类就是标准的Javabean

    /**
     * 内省api测试 获取bean类的元数据
     *
     * @throws IntrospectionException 内省例外
     */
    @Test
    void IntrospectorTest() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            logger.info("propertyDescriptorType:{}", propertyDescriptor.getPropertyType());
            logger.info("propertyDescriptorName:{}", propertyDescriptor.getName());
            logger.info("propertyDescriptorReadMethod:{}", propertyDescriptor.getReadMethod());
            logger.info("propertyDescriptorWriteMethod:{}", propertyDescriptor.getWriteMethod());
        }
    }

    /**
     * BeanUtil测试
     *
     * @throws IntrospectionException    内省例外
     * @throws InvocationTargetException 调用目标异常
     * @throws IllegalAccessException    非法访问异常
     */
    @Test
    void BeanUtilTest() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        //因为我们从beanDefinition中获取到的bean元数据是字符串类型的，所以我们需要将其转换为对应的类型
        //获取bean的属性值并给其赋值
        User user = new User();
        BeanUtils.setProperty(user, "name", "张三");
        BeanUtils.setProperty(user, "age", 18);
    }



}
