package com.ecommerce.onlinebookshop.cart;

import com.ecommerce.onlinebookshop.cart.CartDto;
import com.ecommerce.onlinebookshop.model.entity.Cart;

public class CartMapper {

    public static CartDto mapToCartDto(Cart cart){
        CartDto cartDto =CartDto.builder()
                .id(cart.getId())
                .build();
        return cartDto;
    }

    public static Cart mapToCart(CartDto cartDto){
        Cart cart = Cart.builder()
                .id(cartDto.getId())
                .build();
        return cart;
    }
}
