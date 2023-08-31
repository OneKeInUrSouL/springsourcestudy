package com.example.springsourcestudy.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WebSpecificBean {
    String message;
    public void performAction(){
        System.out.println("执行特定于 Web 环境的操作");
    }
}
