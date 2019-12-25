package com.example.demo;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class EventFormatter implements Formatter<Event> {
    @Override
    public String print(Event event, Locale locale) {
        return event.getId().toString();
    }

    @Override
    public Event parse(String s, Locale locale) throws ParseException {
        return new Event(Integer.parseInt(s));
    }
}
