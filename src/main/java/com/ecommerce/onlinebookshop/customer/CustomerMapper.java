package com.ecommerce.onlinebookshop.customer;

import com.ecommerce.onlinebookshop.customer.CustomerDto;
import com.ecommerce.onlinebookshop.model.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer){
        CustomerDto customerDto= CustomerDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .shippingAddress(customer.getShippingAddress())
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
                .shippingAddress(customerDto.getShippingAddress())
                .orders(customerDto.getOrders())
                .cart(customerDto.getCart())
                .build();
        return customer;
    }
}
