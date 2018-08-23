package com.alfinandika.belajarspring.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class DataBean {

    private String value;

    public DataBean(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @PostConstruct
    public void init(){
        System.out.println("init databean : "+value);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy databean : "+value);
    }
}
