package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {
    @Autowired
    private String hello;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(hello);
    }
}
