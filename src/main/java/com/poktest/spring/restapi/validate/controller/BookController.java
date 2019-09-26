package com.poktest.spring.restapi.validate.controller;

import com.poktest.spring.restapi.validate.error.BookNotFoundException;
import com.poktest.spring.restapi.validate.error.BookUnSupportedFieldPatchException;
import com.poktest.spring.restapi.validate.model.Book;
import com.poktest.spring.restapi.validate.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookRepository repository ;

    @GetMapping()
    List<Book> findAll(){
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    Book newBook(@Valid @RequestBody Book newBook){
        return repository.save(newBook);
    }

    @GetMapping("/{id}")
    Book findOne(@PathVariable Long id){
        return repository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
    }

    @PutMapping("/{id}")
    Book saveOrUpdate(@RequestBody Book newBook,@PathVariable Long id){
        return repository.findById(id).map(x->{
            x.setName(newBook.getName());
            x.setAuthor(newBook.getAuthor());
            x.setPrice(newBook.getPrice());
            return repository.save(x);
        }).orElseGet(()->{
            newBook.setId(id);
            return repository.save(newBook);
        });
    }

    @PatchMapping("/{id}")
    Book patch(@RequestBody Map<String,String> update, @PathVariable Long id){
        return repository.findById(id).map(x->{
            String author  =  update.get("author");
            if(!StringUtils.isEmpty(author)){
                x.setAuthor(author);
                return repository.save(x);
            }else{
                throw new BookUnSupportedFieldPatchException(update.keySet());
            }
        }).orElseGet(()->{
            throw new BookNotFoundException(id);
        });
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
