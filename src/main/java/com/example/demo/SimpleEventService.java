package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class SimpleEventService implements EventService {
    @Override
    public void creaateEvent() {
        long begin = System.currentTimeMillis();

        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Create an Event");

        System.out.println(System.currentTimeMillis()-begin);
    }

    @Override
    public void pulishEvent() {
        long begin = System.currentTimeMillis();

        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Pulished an event");
        System.out.println(System.currentTimeMillis()-begin);
    }
}
