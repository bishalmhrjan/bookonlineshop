package com.ecommerce.onlinebookshop.cartitem;

import com.ecommerce.onlinebookshop.model.entity.CartItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartItemController.class)
class CartItemControllerTest {

    @Autowired
    private ObjectMapper  objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CartItemService cartItemService;

    private final String BASE_URL ="/api/cartitems";


    @Test
    @WithMockUser
    void getAllCartItems() throws Exception {
        CartItem cartItem1 = CartItem.builder()
                .id(1L)
                .build();
        CartItem cartItem2 = CartItem.builder()
                .id(2L)
                .build();
        CartItem cartItem3 = CartItem.builder()
                .id(3L)
                .build();
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);
        cartItems.add(cartItem3);



        when(cartItemService.getAllCartItems()).thenReturn(cartItems);

        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(3))
                .andExpect(jsonPath("$[0].id").value(1L));

        verify(cartItemService,times(1)).getAllCartItems();
    }

    @Test
    @WithMockUser
    void getCartItemById() throws Exception  {
        CartItem cartItem1 = CartItem.builder()
                .id(1L)
                .build();
        CartItem cartItem2 = CartItem.builder()
                .id(2L)
                .build();
        CartItem cartItem3 = CartItem.builder()
                .id(3L)
                .build();
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);
        cartItems.add(cartItem3);



        when(cartItemService.getAllCartItems()).thenReturn(cartItems);
        when(cartItemService.getCartitemById(1L)).thenReturn(Optional.of(cartItem1));
        mockMvc.perform(get(BASE_URL+"/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));

        verify(cartItemService,times(1)).getCartitemById(1L);
    }

    @Test
    @WithMockUser
    void createCartItem() throws Exception  {
        CartItem cartItem1 = CartItem.builder()
                .id(1L)
                .build();
        CartItem cartItem2 = CartItem.builder()
                .id(2L)
                .build();
        CartItem cartItem3 = CartItem.builder()
                .id(3L)
                .build();
        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem1);
        cartItems.add(cartItem2);
        cartItems.add(cartItem3);

        when(cartItemService.addCartItem(any(CartItem.class))).thenReturn(cartItem3);

        mockMvc.perform(post(BASE_URL)
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cartItem3)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(3L));

        verify(cartItemService,times(1)).addCartItem(cartItem3);

    }

    @Test
    @WithMockUser
    void deleteCartItem_ShouldNotReturnContent() throws Exception  {
        doNothing().when(cartItemService).deleteCartItem(1L);
        mockMvc.perform(delete(BASE_URL+"/1")
                .with(csrf()))
                .andExpect(status().isNoContent());
        verify(cartItemService,times(1)).deleteCartItem(1L);
    }
}