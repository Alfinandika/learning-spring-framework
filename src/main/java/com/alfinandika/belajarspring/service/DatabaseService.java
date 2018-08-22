package com.alfinandika.belajarspring.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DatabaseService {

    @PostConstruct
    public  void openConnection(){
        System.out.println("menbuka koneksi ke database");
    }

    @PreDestroy
    public  void closeConnection(){
        System.out.println("menutup koneksi ke database");
    }
}
