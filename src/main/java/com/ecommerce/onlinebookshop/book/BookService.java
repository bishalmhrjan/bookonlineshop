package com.ecommerce.onlinebookshop.book;

import com.ecommerce.onlinebookshop.model.entity.book.Book;
import com.ecommerce.onlinebookshop.book.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

        public List<Book> getAllBooks( ){
            return bookRepository.findAll();
         }

     public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
     }

     public Book addBook(Book book){
        return bookRepository.save(book);
     }

     public void deleteBookById(Long id){
        bookRepository.deleteById(id);
     }
}
