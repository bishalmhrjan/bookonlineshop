package com.ecommerce.onlinebookshop.cart;

import com.ecommerce.onlinebookshop.model.entity.Cart;
import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {

    @Mock
    private CartRepository cartRepository;
    @InjectMocks
    private CartService cartService;
    @Test
    void getAllCarts() {
        List<Cart> carts = new ArrayList<>();
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();
        carts.add(cart1);
        carts.add(cart2);
        carts.add(cart3);

    when(cartRepository.findAll()).thenReturn(carts);
    List<Cart> result = cartService.getAllCarts();

    assertEquals(3,result.size());
    verify(cartRepository,times(1)).findAll();

    }

    @Test
    void getCartById() {
        List<Cart> carts = new ArrayList<>();
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();

        Long id = 1L;
        carts.add(cart1);
        carts.add(cart2);
        carts.add(cart3);

        cart1.setId(id);

        when(cartRepository.findById(id)).thenReturn(Optional.of(cart1));
        Optional<Cart> result = cartService.getCartById(id);

        assertEquals(id,result.get().getId());
        verify(cartRepository, times(1)).findById(id);
    }

    @Test
    void addCart() {
        List<Cart> carts = new ArrayList<>();
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();


        carts.add(cart1);
        carts.add(cart2);

        when(cartRepository.findAll()).thenReturn(carts);
        List<Cart> result = cartService.getAllCarts();

        assertEquals(2,result.size());

        carts.add(cart3);


        when(cartRepository.findAll()).thenReturn(carts);
         result = cartService.getAllCarts();

        assertEquals(3,result.size());

    }

    @Test
    void deleteCart() {

        List<Cart> carts = new ArrayList<>();
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();


        carts.add(cart1);
        carts.add(cart2);
        carts.add(cart3);

        when(cartRepository.findAll()).thenReturn(carts);
        List<Cart> result = cartService.getAllCarts();

        assertEquals(3,result.size());

        carts.remove(cart3);


        when(cartRepository.findAll()).thenReturn(carts);
        result = cartService.getAllCarts();

        assertEquals(2,result.size());
    }

    @Test
    void findCartByCustomerFirstName() {
        List<Cart> carts = new ArrayList<>();
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();

        String customerName ="Bishal";
        Long id = 1L;
        carts.add(cart1);
        carts.add(cart2);
        carts.add(cart3);

        User user = new Customer();
        User user2 = new Customer();

        user.setFirstName(customerName);
        user2.setFirstName(customerName);

        cart1.setUser(user);
        cart2.setUser(user2);

        List<Cart> sameNameAdminList = new ArrayList<>();

        sameNameAdminList.add(cart1);
        sameNameAdminList.add(cart2);



        when(cartRepository.findCartByCustomerFirstName(customerName)).thenReturn(sameNameAdminList);
        List<Cart> result = cartService.findCartByCustomerFirstName(customerName);

        assertEquals(2,result.size());
        verify(cartRepository, times(1)).findCartByCustomerFirstName(customerName);
    }
}