package com.ecommerce.onlinebookshop.cart;

import com.ecommerce.onlinebookshop.model.entity.Cart;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CartController.class)
class CartControllerTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CartController cartController;
    @MockitoBean
    private CartService cartService;

    private final String BASE_URL ="/api/carts";
    @Test
    @WithMockUser
    void getAllCarts() throws Exception {

        Cart cart1 = Cart.builder()
                        .id(1L)
                        .build();
        Cart cart2 = Cart.builder()
                        .id(2L)
                        .build();
        Cart cart3 = Cart.builder()
                         .id(3L)
                         .build();
        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart1);
        cartList.add(cart2);
        cartList.add(cart3);

        when(cartService.getAllCarts()).thenReturn(cartList);
        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(3))
                .andExpect(jsonPath("$[0].id").value(1L));

    }

    @Test
    @WithMockUser
    void getCartById() throws Exception {
        Cart cart1 = Cart.builder()
                .id(1L)
                .build();
        Cart cart2 = Cart.builder()
                .id(2L)
                .build();
        Cart cart3 = Cart.builder()
                .id(3L)
                .build();
        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart1);
        cartList.add(cart2);
        cartList.add(cart3);

        when(cartService.getCartById(1L)).thenReturn(Optional.of(cart1));
        when(cartService.getAllCarts()).thenReturn(cartList);

        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(3))
                .andExpect(jsonPath("$[0].id").value(1L));
    }

    @Test
    @WithMockUser
    void createCart() throws  Exception {
        Cart cart1 = Cart.builder()
                .id(1L)
                .build();
        Cart cart2 = Cart.builder()
                .id(2L)
                .build();
        Cart cart3 = Cart.builder()
                .id(3L)
                .build();
        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart1);
        cartList.add(cart2);
    ;

        when(cartService.addCart(any(Cart.class))).thenReturn(cart3) ;
        when(cartService.getAllCarts()).thenReturn(cartList);

        mockMvc.perform(post(BASE_URL)
                .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cart3)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(3L));
        verify(cartService,times(1)).addCart(cart3);
    }

    @Test
    @WithMockUser
    void deleteCart_ShouldReturnNoContent() throws Exception{
        doNothing().when(cartService).deleteCart(1L);
        mockMvc.perform(delete(BASE_URL+"/1")
                .with(csrf()))
                .andExpect(status().isNoContent());
    verify(cartService,times(1)).deleteCart(1L);
    }
}