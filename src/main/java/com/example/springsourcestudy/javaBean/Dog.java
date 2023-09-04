package com.example.springsourcestudy.javaBean;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Dog {
    private String name;
    private String color;
    @PostConstruct
    public void init(){
        System.out.println("Dog init------------------------");
    }
}
