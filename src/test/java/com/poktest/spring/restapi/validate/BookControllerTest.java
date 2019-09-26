//package com.poktest.spring.restapi.validate;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.poktest.spring.restapi.validate.model.Book;
//import com.poktest.spring.restapi.validate.repository.BookRepository;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import javax.servlet.http.HttpServletRequest;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.hamcrest.Matchers.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@ActiveProfiles("test")
//public class BookControllerTest {
//    private static final ObjectMapper om = new ObjectMapper();
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private BookRepository mockRepository;
//
//    /*
//       {
//           "timestamp":"2019-03-05T09:34:13.280+0000",
//           "status":400,
//           "errors":["Author is not allowed.","Please provide a price","Please provide a author"]
//       }
//    */
//    @Test
//    public void bookControllerTest_26 () throws Exception {
//        String rq = "{\"name\":\"ABC\"}";
//        mockMvc.perform(MockMvcRequestBuilders.post("/book").content(rq).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isBadRequest())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", Matchers.is(Matchers.notNullValue())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is(400)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.errors").isArray())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.errors", Matchers.hasSize(3)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.errors", Matchers.hasItem("Author is not allowed.")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.errors", Matchers.hasItem("Please provide a author")))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.errors", Matchers.hasItem("Please provide a price")));
//
//        Mockito.verify(mockRepository, Mockito.times(0)).save(ArgumentMatchers.any(Book.class));
//
//
//
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
//    public void save_invalidAuthor_400() throws Exception {
//
//        String bookInJson = "{\"name\":\" Spring REST tutorials\", \"author\":\"pok\",\"price\":\"9.99\"}";
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/book")
//                .content(bookInJson)
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isBadRequest())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", Matchers.is(Matchers.notNullValue())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is(400)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.errors").isArray())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.errors", Matchers.hasSize(1)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.errors", Matchers.hasItem("Author is not allowed.")));
//
//        Mockito.verify(mockRepository, Mockito.times(0)).save(ArgumentMatchers.any(Book.class));
//
//    }
//}
