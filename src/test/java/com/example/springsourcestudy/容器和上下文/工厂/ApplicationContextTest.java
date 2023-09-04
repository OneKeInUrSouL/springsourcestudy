package com.example.springsourcestudy.容器和上下文.工厂;

import com.example.springsourcestudy.ApplicationAware.MyApplicationAwareBean;
import com.example.springsourcestudy.javaBean.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.metrics.StartupStep;

@SpringBootTest
public class ApplicationContextTest {
    /**
     * 记录应用程序启动的步骤
     */
    @Test
    public void testApplicationStartUp() {
        BufferingApplicationStartup bufferingApplicationStartup = new BufferingApplicationStartup(64);
        StartupStep startupStep = bufferingApplicationStartup.start("第一件事情");
        startupStep.tag("tag1", "xxx1");
        startupStep.end();
        StartupStep startupStep2 = bufferingApplicationStartup.start("第二件事情");
        startupStep2.tag("tag2", "xxx2");
        startupStep2.end();
    }

    /**
     * 测试应用程序感知bean
     */
    @Test
    public void testApplicationAwareBean() {
        GenericApplicationContext context = new GenericApplicationContext();
        // 注册 User bean
        context.registerBean(User.class, () -> new User("单凤池", 29));

        // 注册 MyApplicationAwareBean bean
        context.registerBean(MyApplicationAwareBean.class, MyApplicationAwareBean::new);

        // 刷新容器
        context.refresh();

        // 获取 MyApplicationAwareBean bean
        MyApplicationAwareBean bean = context.getBean(MyApplicationAwareBean.class);

        // 调用 bean 的方法
        bean.doSomething();
    }
}
