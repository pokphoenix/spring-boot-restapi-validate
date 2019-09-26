//package com.poktest.spring.restapi.validate;
//
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.poktest.spring.restapi.validate.model.Book;
//import com.poktest.spring.restapi.validate.repository.BookRepository;
//import org.json.JSONException;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.Mockito;
//import org.skyscreamer.jsonassert.JSONAssert;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.*;
//import org.springframework.test.context.ActiveProfiles;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // for restTemplate
//@ActiveProfiles("test")
//public class BookControllerRestTemplateTest {
//    private static final ObjectMapper om = new ObjectMapper();
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @MockBean
//    private BookRepository mockRepository;
//
//    /*
//        {
//            "timestamp":"2019-03-05T09:34:13.280+0000",
//            "status":400,
//            "errors":["Author is not allowed.","Please provide a price","Please provide a author"]
//        }
//     */
//    @Test
//    public void save_emptyAuthor_emptyPrice_400() throws JSONException {
//
//        String bookInJson = "{\"name\":\"ABC\"}";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> entity = new HttpEntity<>(bookInJson, headers);
//
//        // send json with POST
//        ResponseEntity<String> response = restTemplate.postForEntity("/books", entity, String.class);
//        //printJSON(response);
//
//        String expectedJson = "{\"status\":400,\"errors\":[\"Author is not allowed.\",\"Please provide a price\",\"Please provide a author\"]}";
//        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        JSONAssert.assertEquals(expectedJson, response.getBody(), false);
//
//        Mockito.verify(mockRepository, Mockito.times(0)).save(ArgumentMatchers.any(Book.class));
//
//    }
//
//    /*
//        {
//            "timestamp":"2019-03-05T09:34:13.207+0000",
//            "status":400,
//            "errors":["Author is not allowed."]
//        }
//     */
//    @Test
//    public void save_invalidAuthor_400() throws JSONException {
//
//        String bookInJson = "{\"name\":\" Spring REST tutorials\", \"author\":\"abc\",\"price\":\"9.99\"}";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> entity = new HttpEntity<>(bookInJson, headers);
//
//        //Try exchange
//        ResponseEntity<String> response = restTemplate.exchange("/books", HttpMethod.POST, entity, String.class);
//
//        String expectedJson = "{\"status\":400,\"errors\":[\"Author is not allowed.\"]}";
//        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        JSONAssert.assertEquals(expectedJson, response.getBody(), false);
//
//        Mockito.verify(mockRepository, Mockito.times(0)).save(ArgumentMatchers.any(Book.class));
//
//    }
//
//    private static void printJSON(Object object) {
//        String result;
//        try {
//            result = om.writerWithDefaultPrettyPrinter().writeValueAsString(object);
//            System.out.println(result);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }
//}
