package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ProxySimpleEventService implements EventService {
    @Autowired
    SimpleEventService simpleEventService;

    @Override
    public void creaateEvent() {
        long begin = System.currentTimeMillis();
        simpleEventService.creaateEvent();
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void pulishEvent() {
        long begin = System.currentTimeMillis();
        simpleEventService.pulishEvent();
        System.out.println(System.currentTimeMillis() - begin);
    }
}
