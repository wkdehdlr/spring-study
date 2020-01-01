package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class SampleListener  {

    public SampleListener(ApplicationArguments arguments){
        System.out.println("foo " + arguments.containsOption("foo"));
        System.out.println("bar " +arguments.containsOption("bar"));
    }
}
