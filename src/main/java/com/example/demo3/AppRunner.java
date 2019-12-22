package com.example.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

  @Autowired
  ResourceLoader resourceLoader;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("xxx.xml");
    ctx.getResource("text.txt");
    ctx.getResource("file:///text.txt");

    ApplicationContext ctxx = new FileSystemXmlApplicationContext("xxx.xml");
    ctxx.getResource("text.path");
    ctxx.getResource("classpath:text.txt");
  }
}
