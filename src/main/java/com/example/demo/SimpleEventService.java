package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class SimpleEventService implements EventService {

    @PerLogging
    @Override
    public void creaateEvent() {
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Create an Event");
    }

    @Override
    public void pulishEvent() {
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Pulished an event");
    }
}
