package com.ecommerce.onlinebookshop.customer;

import com.ecommerce.onlinebookshop.model.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/customers")
@PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
public class CustomerController {

    private final CustomerService customerService;



    public CustomerController(CustomerService cartItemItemService) {
        this.customerService = cartItemItemService;
    }




    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerId(@PathVariable Long id){
        Optional<Customer> cartItem= customerService.getCustomerById(id);
        return cartItem.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer customerToSave= customerService.addCustomer(customer);
    return     ResponseEntity.status(HttpStatus.CREATED).body(customerToSave);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){

        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }


}
