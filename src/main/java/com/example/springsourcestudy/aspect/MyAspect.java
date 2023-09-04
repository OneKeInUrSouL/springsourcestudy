package com.example.springsourcestudy.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
//    @Before("execution(* com.example.springsourcestudy.aspect.MyServiceImpl.*(..))") //CGLIB的方式主要是针对类的，所以这里要用MyServiceImpl,spring aop默认使用的是CGLIB
    @Before("execution(* com.example.springsourcestudy.aspect.MyService.*(..))") //JDK的方式主要是针对接口的，所以这里要用MyService
    public void before() {
        System.out.println("before do something");
    }
}
