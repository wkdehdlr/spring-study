package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/hello")
    public String hello() throws InterruptedException {
        Thread.sleep(5000);
        return "hello";
    }

    @GetMapping("/bye")
    public String bye() throws InterruptedException {
        Thread.sleep(3000);
        return "bye";
    }
}
