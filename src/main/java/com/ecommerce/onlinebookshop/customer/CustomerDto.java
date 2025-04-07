package com.ecommerce.onlinebookshop.customer;

import com.ecommerce.onlinebookshop.model.entity.Adress;
import com.ecommerce.onlinebookshop.model.entity.Cart;
import com.ecommerce.onlinebookshop.model.entity.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CustomerDto {
    private String firstName;
    private String lastName;
    private String email;


    private Adress shippingAddress;


    private Adress billingAddress;

    private List<Order> orders;

    private Cart cart;
}
