package com.poktest.spring.restapi.validate.error;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Book id not found : " + id);
    }
}
