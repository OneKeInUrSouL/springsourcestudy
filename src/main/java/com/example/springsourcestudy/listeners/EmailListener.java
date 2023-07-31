package com.example.springsourcestudy.listeners;

import org.springframework.context.ApplicationListener;

/**
 * 电子邮件监听器
 *
 * @author OneKeInUrSoul
 * @since 2023/07/31
 */
public class EmailListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent event) {
        System.out.println(event.getSource() + "发送邮件");
    }
}
