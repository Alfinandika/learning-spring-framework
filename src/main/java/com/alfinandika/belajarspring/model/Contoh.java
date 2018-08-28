package com.alfinandika.belajarspring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Contoh {

    private String authorName;
    private int nilai;

    @Autowired
    public Contoh(@Value("#{ author.name }") String authorName, @Value("#{ 10*10 }") int nilai) {
        this.authorName = authorName;
        this.nilai = nilai;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}
