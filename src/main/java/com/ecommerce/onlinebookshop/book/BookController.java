package com.ecommerce.onlinebookshop.book;

import com.ecommerce.onlinebookshop.model.entity.book.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@PreAuthorize("hasanyRole('ADMIN','EMPLOYEE')")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllbooks(){
        List<Book> books= bookService.getAllBooks();
        return  ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getbookById(@PathVariable Long id){
        Optional<Book> book= bookService.getBookById(id);
        return book.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> createbook(@RequestBody Book book){
        Book toBeSaved= bookService.addBook(book);
       return ResponseEntity.status(HttpStatus.CREATED).body(toBeSaved);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletebook(@PathVariable Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
