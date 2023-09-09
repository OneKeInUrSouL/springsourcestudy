package com.example.springsourcestudy.before;

import org.springframework.aop.TargetSource;

/**
 * 自定义TargetSource
 * @author OneKeInUrSouL
 * @since 2023/09/09
 */
public class MyTargetSource implements TargetSource {
    @Override
    public Class<?> getTargetClass() {
        return MyBean.class;
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public Object getTarget() throws Exception {
        MyBean myBean = new MyBean();
        myBean.setTitle("my bean title");
        return myBean;
    }

    @Override
    public void releaseTarget(Object target) throws Exception {

    }
}
