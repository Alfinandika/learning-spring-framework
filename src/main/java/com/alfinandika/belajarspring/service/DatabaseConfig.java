package com.alfinandika.belajarspring.service;

public class DatabaseConfig {

    private String value;

    public DatabaseConfig(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
