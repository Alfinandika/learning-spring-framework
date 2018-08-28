package com.alfinandika.belajarspring.service;

import com.alfinandika.belajarspring.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Component
@Validated
public class UserService {

    public void save(@Valid User user){
        System.out.println("sukses menyimpan user baru");
    }

    public User getById(@NotBlank String id){
        return null
    }
}
