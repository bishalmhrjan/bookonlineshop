package com.ecommerce.onlinebookshop.order;

import com.ecommerce.onlinebookshop.model.entity.Order;
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

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private OrderService orderService;

    private final String BASE_URL="/api/orders";
    @Test
    @WithMockUser
    void getAllOrders() throws  Exception{
        Order order1 = Order.builder()
                .id(1L)
                .build();
        Order order2 = Order.builder()
                .id(2L)
                .build();
        Order order3 = Order.builder()
                .id(3L)
                .build();

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        when(orderService.getAllOrders()).thenReturn(orders);

        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(3))
                .andExpect(jsonPath("$[0].id").value(1L));

        verify(orderService,times(1)).getAllOrders();



    }

    @Test
    @WithMockUser
    void getOrderById() throws Exception {
        Order order1 = Order.builder()
                .id(1L)
                .build();
        Order order2 = Order.builder()
                .id(2L)
                .build();
        Order order3 = Order.builder()
                .id(3L)
                .build();

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

    when(orderService.getOrderById(1L)).thenReturn(Optional.of(order1));

    mockMvc.perform(get(BASE_URL+"/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L));
    verify(orderService,times(1)).getOrderById(1L);
    }

    @Test
    @WithMockUser
    void createOrder() throws Exception  {
        Order order1 = Order.builder()
                .id(1L)
                .build();
        Order order2 = Order.builder()
                .id(2L)
                .build();
        Order order3 = Order.builder()
                .id(3L)
                .build();

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        when(orderService.addOrder(any(Order.class))).thenReturn(order1);

        mockMvc.perform(post(BASE_URL)
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(order1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L));

        verify(orderService,times(1)).addOrder(order1);
    }

    @Test
    @WithMockUser
    void deleteOrder() throws Exception {
        doNothing().when(orderService).deleteOrderById(1L);
        mockMvc.perform(delete(BASE_URL+"/1")
                        .with(csrf()))
                .andExpect(status().isNoContent());
        verify(orderService,times(1)).deleteOrderById(1L);
    }
}