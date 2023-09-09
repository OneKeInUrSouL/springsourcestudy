package com.example.springsourcestudy.before;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.TargetSourceCreator;
import org.springframework.stereotype.Component;

@Component
public class MyCustomTargetSourceCreator implements TargetSourceCreator {
    @Override
    public TargetSource getTargetSource(Class<?> beanClass, String beanName) {
        if (beanClass == MyBean.class) {
            return new MyTargetSource();
        }
        return null;
    }
}
