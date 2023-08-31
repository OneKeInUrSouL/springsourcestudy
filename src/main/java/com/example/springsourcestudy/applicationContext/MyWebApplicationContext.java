package com.example.springsourcestudy.applicationContext;

import com.example.springsourcestudy.config.WebSpecificBean;
import org.springframework.beans.BeansException;
import org.springframework.web.context.support.GenericWebApplicationContext;

public class MyWebApplicationContext extends GenericWebApplicationContext {
    /**
     * Template method which can be overridden to add context-specific refresh work.
     * Called on initialization of special beans, before instantiation of singletons.
     * <p>This implementation is empty.
     *
     * @throws BeansException in case of errors
     * @see #refresh()
     */
    @Override
    protected void onRefresh() throws BeansException {
        super.onRefresh();
        // 在容器刷新时执行特定于 Web 环境的初始化操作
        System.out.println("执行特定于 Web 环境的初始化操作");
        //获取特定于 Web 环境的 Bean
        WebSpecificBean webSpecificBean = getBean("webSpecificBean", WebSpecificBean.class);
        webSpecificBean.performAction();
        System.out.println(webSpecificBean.getMessage());
        // 执行其他的特定于 Web 环境的初始化操作
        System.out.println("执行其他的特定于 Web 环境的初始化操作");
        //初始化完成
        System.out.println("初始化完成");

    }
}
