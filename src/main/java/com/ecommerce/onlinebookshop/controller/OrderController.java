package com.ecommerce.onlinebookshop.controller;

import com.ecommerce.onlinebookshop.model.entity.Order;
import com.ecommerce.onlinebookshop.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class OrderController {
    private final OrderService orderService;



    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllCartItems(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getCartItemById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Order createCartItem(@RequestBody Order Order){
        return orderService.addOrder(Order);
    }

    @DeleteMapping
    public void deleteCartItem(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
}
