package com.example.springsourcestudy.listeners;

import org.springframework.context.ApplicationEvent;

/**
 * 事件顺序
 *
 * @author OneKeInUrSoul
 * @since 2023/07/31
 */
public class OrderEvent extends ApplicationEvent {
    private final String name;
    public OrderEvent(Object source,String name) {
        super(source);
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
