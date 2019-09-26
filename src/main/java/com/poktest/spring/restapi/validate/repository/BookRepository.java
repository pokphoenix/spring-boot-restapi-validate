package com.poktest.spring.restapi.validate.repository;

import com.poktest.spring.restapi.validate.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Long> {

}
