package com.ecommerce.onlinebookshop.model.entity.book;

import jakarta.persistence.Embeddable;

@Embeddable
public class BookDescription {

    private String description;
    private String imageUrl;

    private double rating;
}
