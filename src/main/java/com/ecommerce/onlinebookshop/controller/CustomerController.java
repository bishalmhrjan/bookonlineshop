package com.ecommerce.onlinebookshop.controller;

import com.ecommerce.onlinebookshop.model.entity.CartItem;
import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CustomerController {
    private final CustomerService customerService;



    public CustomerController(CustomerService cartItemItemService) {
        this.customerService = cartItemItemService;
    }

    @GetMapping
    public List<Customer> getAllCartItems(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCartItemById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer createCartItem(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @DeleteMapping
    public void deleteCartItem(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }
}
