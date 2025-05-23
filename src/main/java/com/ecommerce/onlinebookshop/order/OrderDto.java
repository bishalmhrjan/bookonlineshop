package com.ecommerce.onlinebookshop.order;

import com.ecommerce.onlinebookshop.model.entity.Adress;
import com.ecommerce.onlinebookshop.model.entity.Cart;
import com.ecommerce.onlinebookshop.model.entity.CartItem;
import com.ecommerce.onlinebookshop.model.entity.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;

    private double amount;


    private Adress shippingAddress;



    private Adress billingAddress;

     private List<CartItem> historyCart;


 }
