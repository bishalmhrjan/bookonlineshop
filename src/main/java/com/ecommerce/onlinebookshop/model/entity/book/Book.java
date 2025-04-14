package com.ecommerce.onlinebookshop.model.entity.book;


import com.ecommerce.onlinebookshop.exception.BookInvalidException;
import com.ecommerce.onlinebookshop.model.entity.AuditDetails;
import com.ecommerce.onlinebookshop.model.enums.BookType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //generates Getters, setters, hascode and toString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double price;
    private int stockQuantity;

    @Enumerated(EnumType.STRING)
    private BookType category;

    @Embedded
    private BookMetaData bookMetaData;

    @Embedded
    private BookDescription description;

    @Embedded
    private AuditDetails auditDetails;


    public Book(String title, double price, int stockQuantity, BookType category, BookMetaData bookMetaData, BookDescription description, AuditDetails auditDetails) throws BookInvalidException {
        if(title.equals("")||title.equals(null)){
            throw new BookInvalidException();
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative.");
        }

        this.title = title;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.bookMetaData = bookMetaData;
        this.description = description;
        this.auditDetails = auditDetails;
    }


}
