package com.ecommerce.onlinebookshop.model.entity.book;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data //generates Getters, setters, hascode and toString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDescription {

    private String description;
    private String imageUrl;

    private double rating;
}
