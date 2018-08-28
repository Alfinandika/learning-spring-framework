package com.alfinandika.belajarspring.validation;

import com.alfinandika.belajarspring.model.Author;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AuthorValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Author.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Author author = (Author) o;

        if(author.getName() == null || author.getName().trim().isEmpty()){
            errors.rejectValue("name", "author.email.blank");
        }

        if(author.getEmail() == null || author.getEmail().trim().isEmpty()){
            errors.rejectValue("name", "author.name.blank");
        }
    }
}
