package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(SampleRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("====================");
        logger.info("logger");
        logger.info("Debug");
        logger.info("=====================");

    }
}
