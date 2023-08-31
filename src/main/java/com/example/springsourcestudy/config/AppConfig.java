package com.example.springsourcestudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.springsourcestudy")
public class AppConfig {
    @Bean(name = "webSpecificBean")
    public WebSpecificBean webSpecificBean() {
        return new WebSpecificBean("webSpecificBean");
    }
}
