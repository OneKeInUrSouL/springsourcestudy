package com.example.springsourcestudy.SmartInitializingSingleton;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

@Component
public class MySmartInitializingSingleton implements SmartInitializingSingleton {
    @Override
//    @PostConstruct// 该注解表示该方法会在构造器执行完毕前执行
    public void afterSingletonsInstantiated() {
        System.out.println("所有单例Bean已经初始化完毕！");
    }
}
