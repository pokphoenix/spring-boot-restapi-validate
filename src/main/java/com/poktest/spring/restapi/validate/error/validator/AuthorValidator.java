package com.poktest.spring.restapi.validate.error.validator;

import org.hibernate.validator.cfg.context.Constrainable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class AuthorValidator implements ConstraintValidator<Author,String> {
    List<String> authors  = Arrays.asList("Santideva", "Marie Kondo", "Martin Fowler", "mkyong");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return authors.contains(s);
    }
}
