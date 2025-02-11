package com.ecommerce.onlinebookshop.model.entity;

import com.ecommerce.onlinebookshop.model.entity.book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data //generates Getters, setters, hascode and toString
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CartItem> bookId; // after success buy, cart gets empty
    private double totalPrice;
    @OneToOne
    private Customer customer;


}
