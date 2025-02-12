package com.ecommerce.onlinebookshop.controller;

import com.ecommerce.onlinebookshop.model.entity.Order;
import com.ecommerce.onlinebookshop.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService ;



    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllCartItems(){
        List<Order> orders= orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getCartItemById(@PathVariable Long id){
        Optional<Order> orderToGet= orderService.getOrderById(id);
        return orderToGet.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Order>   createCartItem(@RequestBody Order Order){
        Order orderToSave= orderService.addOrder(Order);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderToSave);


    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
