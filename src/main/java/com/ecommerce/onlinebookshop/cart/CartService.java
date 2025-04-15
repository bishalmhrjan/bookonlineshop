package com.ecommerce.onlinebookshop.cart;

import com.ecommerce.onlinebookshop.model.entity.Cart;
import com.ecommerce.onlinebookshop.cart.CartRepository;
import com.ecommerce.onlinebookshop.utility.ConcreteValidChecker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Transactional
    public Cart addCart(Cart cart){
        if(cart == null){
            throw  new IllegalArgumentException("cart is null");
        }
        return  cartRepository.save(cart);
    }

    @Transactional
    public void  deleteCart(Long id){
        if(ConcreteValidChecker.validId(id) && cartRepository.findById(id) != null){
            cartRepository.deleteById(id);

        }
        throw new IllegalArgumentException("id is invalid");
    }

   /* public List<Cart> findCartLesserThantotalPrice(double totalPrice){
        if(totalPrice<0){
            throw new IllegalArgumentException("total price can not be below zero!");
        }
       return cartRepository.findCartLesserThantotalPrice(totalPrice);
    }
*/
    public List<Cart> findCartByCustomerFirstName(String firstName){
        if(ConcreteValidChecker.validString(firstName)){
            return cartRepository.findCartByCustomerFirstName(firstName);
        }
    throw  new IllegalArgumentException("first name is invalid!!!");
    }
}
