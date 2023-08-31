package com.example.springsourcestudy.ApplicationAware;

import com.example.springsourcestudy.pojo.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.*;
import org.springframework.stereotype.Component;

/**
 * 我的应用程序感知bean
 *
 * @author OneKeInUrSoul
 * @since 2023/08/28
 */
@Component
public class MyApplicationAwareBean implements ApplicationContextAware {
    // 应用程序上下文主要目的是为了在初始化bean的时候可以获取一些特定的资源信息
    private ApplicationContext applicationContext;

    /**
     * Set the ApplicationContext that this object runs in.
     * Normally this call will be used to initialize the object.
     * <p>Invoked after population of normal bean properties but before an init callback such
     * as {@link InitializingBean#afterPropertiesSet()}
     * or a custom init-method. Invoked after {@link ResourceLoaderAware#setResourceLoader},
     * {@link ApplicationEventPublisherAware#setApplicationEventPublisher} and
     * {@link MessageSourceAware}, if applicable.
     *
     * @param applicationContext the ApplicationContext object to be used by this object
     * @throws ApplicationContextException in case of context initialization errors
     * @throws BeansException              if thrown by application context methods
     * @see BeanInitializationException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String getAppName() {
        User bean = applicationContext.getBean(User.class);
        return bean.getName();
    }

    public void doSomething() {
        String appName = getAppName();
        System.out.println("appName:" + appName);
    }
}
