package com.example.demo3;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {
  @Override
  public void run(ApplicationArguments args) throws Exception {
    ApplicationContext ctx = new FileSystemXmlApplicationContext("xxx.xml");

  }
}
