package com.ecommerce.onlinebookshop.controller;

import com.ecommerce.onlinebookshop.model.entity.CartItem;
import com.ecommerce.onlinebookshop.service.CartItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CartItemController {
    private final CartItemService cartItemService;



    public CartItemController(CartItemService cartItemItemService) {
        this.cartItemService = cartItemItemService;
    }

    @GetMapping
    public List<CartItem> getAllCartItems(){
        return cartItemService.getCartItems();
    }

    @GetMapping("/{id}")
    public Optional<CartItem> getCartItemById(@PathVariable Long id){
        return cartItemService.getCartitemById(id);
    }

    @PostMapping
    public CartItem createCartItem(@RequestBody CartItem CartItem){
        return cartItemService.addCartItem(CartItem);
    }

    @DeleteMapping
    public void deleteCartItem(@PathVariable Long id){
        cartItemService.deleteCartItem(id);
    }
}
