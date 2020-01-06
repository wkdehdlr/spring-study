package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

@Component
public class RestRunner implements ApplicationRunner {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        RestTemplate restTemplate = restTemplateBuilder.build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        String helloResult = restTemplate.getForObject("http://localhost:8080/hello", String.class);
        System.out.println(helloResult);

        String worldResult = restTemplate.getForObject("http://localhost:8080/bye", String.class);
        System.out.println(worldResult);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

    }
}
