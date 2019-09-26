package com.poktest.spring.restapi.validate;

import com.poktest.spring.restapi.validate.service.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	BookService bookService ;

	@DisplayName("Test Spring @Autowired Integration")
	@Test
	void testGet() {
		assertEquals(3,bookService.get().size());
	}


}
