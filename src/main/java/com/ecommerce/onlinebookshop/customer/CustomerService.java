package com.ecommerce.onlinebookshop.customer;

import com.ecommerce.onlinebookshop.authcredentials.AuthCredentials;
import com.ecommerce.onlinebookshop.authcredentials.AuthCredentialsRepository;
import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.customer.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService     {
      private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return null;
                /*customerRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList()); */
    }


    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }




    public Customer createCustomer(User  user){
        // Customer customer = new Customer().builder();

        // return customerRepository.save(customer );
        return null;

    }


    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

}
