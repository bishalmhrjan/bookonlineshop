package com.ecommerce.onlinebookshop.model.entity;

import com.ecommerce.onlinebookshop.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data //generates Getters, setters, hascode and toString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private double amount;




    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CartItem> cartItems; // after success buy, cart gets empty


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    /**
     * One order has one to one relation to cart,
     * one cart can have multiple cartitem. rn only books.
     *
     */



}
