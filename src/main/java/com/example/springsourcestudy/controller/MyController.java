package com.example.springsourcestudy.controller;

import com.example.springsourcestudy.aspect.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoke")
public class MyController {
    @Autowired
    MyService myService;
    @GetMapping("/doSomething")
    public String doSomething() {
        return myService.doSomething();
    }
}
