package com.ecommerce.onlinebookshop.model.entity;

import com.ecommerce.onlinebookshop.model.entity.book.Book;
import com.ecommerce.onlinebookshop.user.User;
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

     @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
