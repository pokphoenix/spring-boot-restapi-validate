package com.poktest.spring.restapi.validate.service;

import com.poktest.spring.restapi.validate.model.Book;
import com.poktest.spring.restapi.validate.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository repository;


    public List<Book> get() {
        return repository.findAll();
    }
}
