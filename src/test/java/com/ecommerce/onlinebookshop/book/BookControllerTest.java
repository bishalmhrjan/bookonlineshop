package com.ecommerce.onlinebookshop.book;

import com.ecommerce.onlinebookshop.model.entity.book.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
@WithMockUser
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockitoBean
    private BookService bookService;
    private final String BASE_URL="/api/books";

    @Test

    void getAllbooks() throws Exception {
        Book book1 = Book.builder()
                        .id(1L)
                        .price(20)
                         .build();
        Book book2 = Book.builder()
                .id(2L)
                .price(20)
                .build();

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        when(bookService.getAllBooks()).thenReturn(books);

        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].price").value(20))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$.size()").value(2));
    }

    @Test
    void getbookById() throws Exception {
        Book book1 = Book.builder()
                .id(1L)
                .price(20)
                .build();
        Book book2 = Book.builder()
                .id(2L)
                .price(20)
                .build();

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        when(bookService.getBookById(1L)).thenReturn(Optional.of(book1));

        mockMvc.perform(get(BASE_URL+"/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(20))
                .andExpect(jsonPath("$.id").value(1L));
    }


    @Test
    void createbook() throws Exception{
        Book book1 = Book.builder()
                .id(1L)
                .price(20)
                .build();
        Book book2 = Book.builder()
                .id(2L)
                .price(20)
                .build();

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        when(bookService.addBook(any(Book.class))).thenReturn(book1);

        mockMvc.perform(post(BASE_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.price").value(20))
                .andExpect(jsonPath("$.id").value(1L));

        verify(bookService,times(1)).addBook(book1);
    }

    @Test
    void deletebook() throws Exception {
        doNothing().when(bookService).deleteBookById(1L);
        mockMvc.perform(delete(BASE_URL+"/1")
                        .with(csrf()))
                .andExpect(status().isNoContent());
        verify(bookService,times(1)).deleteBookById(1L);
    }
}