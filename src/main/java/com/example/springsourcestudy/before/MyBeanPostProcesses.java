package com.example.springsourcestudy.before;

import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcesses implements BeanPostProcessor, PriorityOrdered {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof AbstractAutoProxyCreator myBean){
            myBean.setCustomTargetSourceCreators(new MyCustomTargetSourceCreator());
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return -1222;
    }
}
