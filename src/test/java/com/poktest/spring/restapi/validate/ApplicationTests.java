package com.poktest.spring.restapi.validate;

import com.poktest.spring.restapi.validate.model.Book;
import com.poktest.spring.restapi.validate.repository.BookRepository;
import com.poktest.spring.restapi.validate.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ApplicationTests {



//	@Mock
//	private BookRepository repo;
//
//	@InjectMocks
//	BookService bookService ;
//
//	@BeforeEach
//	void setMockOutput() {
//		List<Book> bookList = new ArrayList<>();
//		bookList.add(new Book("A Guide to the Bodhisattva Way of Life", "Santideva", new BigDecimal("15.41")));
//		when(repo.findAll()).thenReturn(bookList);
//	}

	@Autowired
	private BookService bookService;

	@DisplayName("Test Spring @Autowired Integration")
	@Test
	void testGet() {
		List<Book> bookList = bookService.get();
//		assertThat(bookList.size(),greaterThan(2));
		assertThat(bookList.size(),greaterThan(0)); // true
//		bookList.forEach(s->{
//			assertEquals("Santideva", s.getAuthor()); // true
//			assertNotEquals("Santideva", s.getAuthor());
//		});
	}


}
