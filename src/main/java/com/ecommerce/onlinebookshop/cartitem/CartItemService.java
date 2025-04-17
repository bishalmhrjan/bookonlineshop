package com.ecommerce.onlinebookshop.cartitem;

import com.ecommerce.onlinebookshop.model.entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {
    private final CartItemRepository cartItemrepository;

    public CartItemService(CartItemRepository cartItemrepository) {
        this.cartItemrepository = cartItemrepository;
    }

    public List<CartItem> getAllCartItems(){
        return cartItemrepository.findAll();
    }

    public Optional<CartItem> getCartitemById(Long id){
        return cartItemrepository.findById(id);
    }

    public CartItem addCartItem(CartItem cartItem){
        return cartItemrepository.save(cartItem);
    }

    public void deleteCartItem(Long id){
        cartItemrepository.deleteById(id);
    }
}
