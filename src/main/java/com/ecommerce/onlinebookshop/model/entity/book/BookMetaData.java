package com.ecommerce.onlinebookshop.model.entity.book;

import com.ecommerce.onlinebookshop.model.enums.BookFormatType;
import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class BookMetaData {
    private String author;
    private String isbn;

    private String publisher;

    private LocalDate publishDate;

    private String language;

    private BookFormatType formatType;

}
