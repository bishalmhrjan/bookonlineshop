package com.ecommerce.onlinebookshop.service;

import com.ecommerce.onlinebookshop.model.entity.CartItem;
import com.ecommerce.onlinebookshop.repository.CartItemsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {
    private final CartItemsRepository cartItemrepository;

    public CartItemService(CartItemsRepository cartItemrepository) {
        this.cartItemrepository = cartItemrepository;
    }

    public List<CartItem> getCartItems(Long id){
        return cartItemrepository.findAll();
    }

    public Optional<CartItem> getCartitemByCartItemId(Long id){
        return cartItemrepository.findById(id);
    }

    public CartItem addCartItem(CartItem cartItem){
        return cartItemrepository.save(cartItem);
    }

    public void deleteCartItem(Long id){
        cartItemrepository.deleteById(id);
    }
}
