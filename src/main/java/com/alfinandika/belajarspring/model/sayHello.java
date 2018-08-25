package com.alfinandika.belajarspring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class sayHello implements MessageSourceAware {

    private SayHelloFilter filter;

    private MessageSource messageSource;

    @Autowired
    public sayHello(SayHelloFilter filter) {
        this.filter = filter;
    }

    public String hello(String name){
        return filter.filter(messageSource.getMessage("hello", null, Locale.getDefault())+name);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
