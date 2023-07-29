package com.example.springsourcestudy.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Dog {
    private String name;
    private String color;
}
