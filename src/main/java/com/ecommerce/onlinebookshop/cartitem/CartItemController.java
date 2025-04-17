package com.ecommerce.onlinebookshop.cartitem;

import com.ecommerce.onlinebookshop.model.entity.CartItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cartitems")
public class CartItemController {
    private final CartItemService cartItemService;



    public CartItemController(CartItemService cartItemItemService) {
        this.cartItemService = cartItemItemService;
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getAllCartItems(){
        List<CartItem> cartItems= cartItemService.getAllCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable Long id){
        Optional<CartItem> cartItem= cartItemService.getCartitemById(id);
        return   cartItem.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CartItem> createCartItem(@RequestBody CartItem CartItem){
         CartItem toSaveCartItem= cartItemService.addCartItem(CartItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(toSaveCartItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id){
        cartItemService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }
}
