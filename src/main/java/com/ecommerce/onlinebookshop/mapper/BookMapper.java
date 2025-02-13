package com.ecommerce.onlinebookshop.mapper;

import com.ecommerce.onlinebookshop.dto.BookDto;
import com.ecommerce.onlinebookshop.model.entity.book.Book;

public class BookMapper {
    public static BookDto mapToBookDto(Book book){
        BookDto bookDto = BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .price(book.getPrice())
                .stockQuantity(book.getStockQuantity())
                .category(book.getCategory())
                .bookMetaData(book.getBookMetaData())
                .description(book.getDescription())
                .build();

        return  bookDto;
    }

    public static Book mapToBook(BookDto bookDto){
        Book book = Book.builder()
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .price(bookDto.getPrice())
                .stockQuantity(bookDto.getStockQuantity())
                .category(bookDto.getCategory())
                .bookMetaData(bookDto.getBookMetaData())
                .description(bookDto.getDescription())
                .build();

        return book;

    }
}
