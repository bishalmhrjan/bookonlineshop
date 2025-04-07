package com.ecommerce.onlinebookshop.reviewandrating;

import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.model.entity.book.Book;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewAndRatingDto {

    private Long id;

    private Book book;

    private String description;

    private Customer customer;

}
