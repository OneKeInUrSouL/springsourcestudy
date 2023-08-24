package com.example.springsourcestudy.容器和上下文.工厂;

import com.example.springsourcestudy.pojo.User;
import com.example.springsourcestudy.pojo.UserService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.Random;


public class BeanFactoryTest {
    Logger logger = LoggerFactory.getLogger(BeanFactoryTest.class);
    //    @Autowired
    UserService userService;

    /**
     * 测试分级bean工厂
     */
    @Test
    void testHierarchicalBeanFactory() {
        //创建一个核心工厂
        DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();
        parentBeanFactory.registerSingleton("user", new User("单凤池", 29));
        //创建一个子工厂
        DefaultListableBeanFactory childBeanFactory = new DefaultListableBeanFactory(parentBeanFactory);
        System.out.println(childBeanFactory.getBean("user"));
    }

    @Test
    void ObjectProviderTest() {
        //打印
        logger.info(() -> "userService:" + userService.toString());
    }

    @Test
    void testObjectFactory() {
        ObjectFactory<User> factory = () ->
                new Random().nextInt() > 0.5 ? new User("单凤池", 29) : new User("赵珍妮", 28);
        System.out.println(factory.getObject());
    }
}
