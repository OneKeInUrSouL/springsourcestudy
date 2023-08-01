package com.example.springsourcestudy.基础知识.多波器;

import com.example.springsourcestudy.listeners.EmailListener;
import com.example.springsourcestudy.listeners.MessageListener;
import com.example.springsourcestudy.listeners.OrderEvent;
import org.junit.jupiter.api.Test;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.concurrent.Executors;

public class EventMulticasterTests {
    //多波器是spring中的一个事件机制，它是一个接口，它的实现类有两个，一个是SimpleApplicationEventMulticaster，一个是AbstractApplicationEventMulticaster。
    //多波器是典型的观察者模式，它的作用是将事件广播到所有的监听器中，订阅发布模式。
    @Test
    public void testSimpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
        simpleApplicationEventMulticaster.setTaskExecutor(Executors.newFixedThreadPool(10));
        simpleApplicationEventMulticaster.addApplicationListener(new EmailListener());
        simpleApplicationEventMulticaster.addApplicationListener(new MessageListener());

        //使用多波器发布事件
        simpleApplicationEventMulticaster.multicastEvent(new OrderEvent(this, "订单创建"));
    }
}
