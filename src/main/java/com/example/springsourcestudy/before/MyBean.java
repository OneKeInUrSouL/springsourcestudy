package com.example.springsourcestudy.before;

import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
