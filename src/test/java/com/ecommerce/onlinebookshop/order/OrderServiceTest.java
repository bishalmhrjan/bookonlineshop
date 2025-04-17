package com.ecommerce.onlinebookshop.order;

import com.ecommerce.onlinebookshop.model.entity.Order;
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
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void getAllOrders() {
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

        when(orderRepository.findAll()).thenReturn(orders);
        orderService.getAllOrders();
        verify(orderRepository,times(1)).findAll();


    }

    @Test
    void getOrderById() {
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

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order1));
        orderService.getOrderById(1L);
        verify(orderRepository,times(1)).findById(1L);

    }

    @Test
    void addOrder() {
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

        when(orderRepository.save(order1)).thenReturn(order1);
        orderService.addOrder(order1);
        verify(orderRepository,times(1)).save(order1);
    }

    @Test
    void deleteOrderById() {
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

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order1));
       Optional<Order> result= orderService.getOrderById(1L);
               orderService.deleteOrderById(result.get().getId());
        verify(orderRepository,times(1)).deleteById(1L);
    }
}