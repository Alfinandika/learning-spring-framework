package com.alfinandika.belajarspring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class sayHello {

    private SayHelloFilter filter;

    @Autowired
    public sayHello(SayHelloFilter filter) {
        this.filter = filter;
    }

    public String hello(String name){
        return filter.filter("hello "+name);
    }
}
