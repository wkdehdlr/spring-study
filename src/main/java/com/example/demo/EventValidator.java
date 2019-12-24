package com.example.demo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"title","notempty","Empty title is not allowed");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Event.class.equals(aClass);
    }
}
