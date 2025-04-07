package com.ecommerce.onlinebookshop.book;

import com.ecommerce.onlinebookshop.model.entity.book.BookDescription;
import com.ecommerce.onlinebookshop.model.entity.book.BookMetaData;
import com.ecommerce.onlinebookshop.model.enums.BookType;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public  class BookDto {

    private Long id;
    private String title;
    private double price;
    private int stockQuantity;


    private BookType category;


    private BookMetaData bookMetaData;


    private BookDescription description;
}
