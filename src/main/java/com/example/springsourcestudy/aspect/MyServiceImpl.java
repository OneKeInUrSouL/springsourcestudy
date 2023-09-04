package com.example.springsourcestudy.aspect;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService{
    @Override
    public String doSomething() {
        return "do something";
    }
}
