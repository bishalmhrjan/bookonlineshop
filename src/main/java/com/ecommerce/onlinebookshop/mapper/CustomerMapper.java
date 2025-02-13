package com.ecommerce.onlinebookshop.mapper;

import com.ecommerce.onlinebookshop.dto.CustomerDto;
import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.service.CartService;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer){
        CustomerDto customerDto= CustomerDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .billingAddress(customer.getBillingAddress())
                .orders(customer.getOrders())
                .cart(customer.getCart())
                .build();
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto){
        Customer customer = Customer.builder()
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .email(customerDto.getEmail())
                .billingAddress(customerDto.getBillingAddress())
                .orders(customerDto.getOrders())
                .cart(customerDto.getCart())
                .build();
        return customer;
    }
}
