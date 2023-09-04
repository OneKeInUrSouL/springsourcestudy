package com.example.springsourcestudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@PropertySource("classpath:my.properties")
@EnableAspectJAutoProxy
@RestController
public class SpringSourceStudyApplication {
    @Autowired
    Environment environment;
    public static void main(String[] args) {
        SpringApplication.run(SpringSourceStudyApplication.class, args);
    }
    @GetMapping("/helloOne")
    public String hello(){
        return "hello";
    }
}
