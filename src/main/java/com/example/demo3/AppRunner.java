package com.example.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

  @Autowired
  ResourceLoader resourceLoader;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println(resourceLoader.getClass());
    Resource resource = resourceLoader.getResource("classpath:text.txt");
    System.out.println(resource.getClass());
  }
}
