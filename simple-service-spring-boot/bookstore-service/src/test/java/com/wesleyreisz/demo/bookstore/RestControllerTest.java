package com.wesleyreisz.demo.bookstore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wesleyreisz.demo.bookstore.book.BookController;
import com.wesleyreisz.demo.bookstore.book.model.Author;
import com.wesleyreisz.demo.bookstore.book.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by wesleyreisz on 12/30/16.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class RestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private BookController restController;

    @Before
    public void initMockMvc(){
        mockMvc = MockMvcBuilders
                .standaloneSetup(restController)
                .setMessageConverters(jacksonMessageConverter)
                .build();
    }


    @Test
    public void getBooks() throws Exception{
        ResultActions result=this.mockMvc.perform(MockMvcRequestBuilders.get("/books")
                .accept(new MediaType("application", "json")));

        result.andExpect(status()
                .isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.[0].name").isNotEmpty())
                .andExpect(jsonPath("$.[1].name").isNotEmpty())
        ;
    }

    @Test
    public void getBook2() throws Exception {
        this.mockMvc.perform(get("/books/a124")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Card Chronicles"))
                .andExpect(jsonPath("$.author.firstName").value("Matt"))
                .andExpect(jsonPath("$.author.lastName").value("Mathews"))
        ;
    }

    @Test
    public void getBookThatDoesntExist() throws Exception {
        this.mockMvc.perform(get("/books/b124")
                .accept(MediaType.ALL))
                .andExpect(status().is4xxClientError())
        ;
    }


    @Test
    public void addBook() throws Exception {
        String bookJson =
                new ObjectMapper().writeValueAsString(
                        new Book("b124","New Test Book",new Author(11,"Joe","Jones","joe@jones.com"),new Date()
                        )
                );

        this.mockMvc.perform(
                    put("/books")
                        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(bookJson)
                    )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

}
