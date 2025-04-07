package com.ecommerce.onlinebookshop.cart;

import com.ecommerce.onlinebookshop.model.entity.CartItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {

    private Long id;
    private List<CartItem> bookId; // after success buy, cart gets empty
    private double totalPrice;

}
