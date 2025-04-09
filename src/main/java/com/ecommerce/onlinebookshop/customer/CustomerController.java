package com.ecommerce.onlinebookshop.customer;

import com.ecommerce.onlinebookshop.model.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;



    public CustomerController(CustomerService cartItemItemService) {
        this.customerService = cartItemItemService;
    }

 /*   @GetMapping
    public ResponseEntity<List<Customer>> getAllCartItems(){
        List<Customer> customers= customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

  */

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCartItemById(@PathVariable Long id){
        Optional<Customer> cartItem= customerService.getCustomerById(id);
        return cartItem.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Customer> createCartItem(@RequestBody Customer customer){
        Customer customerToSave= customerService.addCustomer(customer);
    return     ResponseEntity.status(HttpStatus.CREATED).body(customerToSave);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id){

        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }


}
