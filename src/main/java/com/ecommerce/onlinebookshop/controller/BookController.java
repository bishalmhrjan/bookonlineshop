package com.ecommerce.onlinebookshop.controller;

import com.ecommerce.onlinebookshop.model.entity.book.Book;
import com.ecommerce.onlinebookshop.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllbooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getbookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book createbook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping
    public void deletebook(@PathVariable Long id){
        bookService.deleteBookById(id);
    }
}
