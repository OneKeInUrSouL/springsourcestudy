package com.example.springsourcestudy;

import com.example.springsourcestudy.applicationContext.MyWebApplicationContext;
import com.example.springsourcestudy.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        // 创建自定义的 Web 应用程序上下文
        MyWebApplicationContext context = new MyWebApplicationContext();

        // 注册配置类
        context.registerBean(AppConfig.class);

        // 刷新应用程序上下文，执行特定于 Web 环境的初始化操作
        context.refresh();

        // 关闭应用程序上下文
        context.close();
    }
}
