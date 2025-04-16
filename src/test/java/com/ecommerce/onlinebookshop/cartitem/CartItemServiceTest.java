package com.ecommerce.onlinebookshop.cartitem;

import com.ecommerce.onlinebookshop.cart.CartRepository;
import com.ecommerce.onlinebookshop.model.entity.Cart;
import com.ecommerce.onlinebookshop.model.entity.CartItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartItemServiceTest {

    @Mock
    private CartItemRepository cartItemRepository;

    @InjectMocks
    private CartItemService cartItemService;




    @Test
    void getCartItems() {
        CartItem cartItem1 = new CartItem();
        CartItem cartItem2 = new CartItem();
        CartItem cartItem3 = new CartItem();


        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);
        cartItems.add(cartItem3);

        when(cartItemRepository.findAll()).thenReturn(cartItems);
        List<CartItem> expectedCartItems = cartItemService.getCartItems();

        assertEquals(3,expectedCartItems.size());
        verify(cartItemRepository, times(1)).findAll();

    }

    @Test
    void getCartitemById() {
        CartItem cartItem1 = new CartItem();
        CartItem cartItem2 = new CartItem();
        CartItem cartItem3 = new CartItem();
        Long id = 1L;
        cartItem1.setId(id);

        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);
        cartItems.add(cartItem3);

        when(cartItemRepository.findById(id)).thenReturn(Optional.of(cartItem1));
        Optional<CartItem> result = cartItemService.getCartitemById(id);

        assertTrue(result.isPresent());
        assertEquals(1L,result.get().getId());
        verify(cartItemRepository,times(1)).findById(id);
    }

    @Test
    void addCartItem() {
        CartItem cartItem1 = new CartItem();
        CartItem cartItem2 = new CartItem();
        CartItem cartItem3 = new CartItem();
        Long id = 1L;
        cartItem1.setId(id);

        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);


        when(cartItemRepository.findAll()).thenReturn(cartItems);
        List<CartItem> result = cartItemService.getCartItems();

         assertEquals(2,result.size());

        cartItems.add(cartItem3);
        when(cartItemRepository.save(cartItem3)).thenReturn(cartItem3);
        cartItemService.addCartItem(cartItem3);

        result = cartItemService.getCartItems();
        assertEquals(3,result.size());

        verify(cartItemRepository,times(1)).save(cartItem3);

    }

    @Test
    void deleteCartItem() {
        CartItem cartItem1 = new CartItem();
        CartItem cartItem2 = new CartItem();
        CartItem cartItem3 = new CartItem();
        Long id = 1L;
        cartItem1.setId(id);

        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);cartItems.add(cartItem3);

        when(cartItemRepository.findById(id)).thenReturn(Optional.of(cartItem1));
        Optional<CartItem> cartItem = cartItemService.getCartitemById(id);
        cartItemService.deleteCartItem(id);

        verify(cartItemRepository,times(1)).deleteById(id);
    }
}