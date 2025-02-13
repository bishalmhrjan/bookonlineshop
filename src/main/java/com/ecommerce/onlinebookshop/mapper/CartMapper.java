package com.ecommerce.onlinebookshop.mapper;

import com.ecommerce.onlinebookshop.dto.CartDto;
import com.ecommerce.onlinebookshop.model.entity.Cart;

public class CartMapper {

    public static CartDto mapToCartDto(Cart cart){
        CartDto cartDto =CartDto.builder()
                .id(cart.getId())
                .bookId(cart.getBookId())
                .totalPrice(cart.getTotalPrice())
                .build();
        return cartDto;
    }

    public static Cart mapToCart(CartDto cartDto){
        Cart cart = Cart.builder()
                .id(cartDto.getId())
                .bookId(cartDto.getBookId())
                .totalPrice(cartDto.getTotalPrice())
                .build();
        return cart;
    }
}
