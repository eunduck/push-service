package com.edkim.core.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FirstConstruct {

    @PostConstruct
    public void init() {
        System.out.println("first");
    }
}
