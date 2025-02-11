package com.ecommerce.onlinebookshop.model.entity;

import com.ecommerce.onlinebookshop.model.entity.book.Book;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data //generates Getters, setters, hascode and toString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Table(name = "cart")
public class Cart {


    private List<Book> bookList; // after success buy, cart gets empty
    private double totalPrice;
    private Customer customer;


}
