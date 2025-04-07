package com.ecommerce.onlinebookshop.service;

import com.ecommerce.onlinebookshop.model.entity.Cart;
import com.ecommerce.onlinebookshop.cartrepository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;


    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAllCarts(){
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(Long id){
        return cartRepository.findById(id);
    }


    public Cart addCart(Cart cart){
        return  cartRepository.save(cart);
    }

    public void  deleteCart(Long id){
        cartRepository.deleteById(id);
    }
}
