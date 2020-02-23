package com.example.demo;

import org.springframework.context.ApplicationListener;

public class PostListener implements ApplicationListener<PostPublishEvent> {
    @Override
    public void onApplicationEvent(PostPublishEvent postPublishEvent) {
        System.out.println("---------");
        System.out.println(postPublishEvent.getPost() + "is published!");
        System.out.println("---------");
    }
}
