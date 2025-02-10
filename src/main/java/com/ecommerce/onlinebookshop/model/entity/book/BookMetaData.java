package com.ecommerce.onlinebookshop.model.entity.book;

import com.ecommerce.onlinebookshop.model.enums.BookFormatType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@Data //generates Getters, setters, hascode and toString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookMetaData {
    private String author;
    private String isbn;

    private String publisher;

    private LocalDate publishDate;

    private String language;

    @Enumerated(EnumType.STRING)
    private BookFormatType formatType;

}
