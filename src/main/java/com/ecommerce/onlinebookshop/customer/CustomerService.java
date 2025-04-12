package com.ecommerce.onlinebookshop.customer;

import com.ecommerce.onlinebookshop.authcredentials.AuthCredentials;
import com.ecommerce.onlinebookshop.authcredentials.AuthCredentialsRepository;
import com.ecommerce.onlinebookshop.cart.CartRepository;
import com.ecommerce.onlinebookshop.model.entity.Cart;
import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.customer.CustomerRepository;
import com.ecommerce.onlinebookshop.utility.ConcreteValidChecker;
import com.ecommerce.onlinebookshop.utility.ValidChecker;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService     {
      private final CustomerRepository customerRepository;
      private CartRepository cartRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Transactional
    public void deleteCustomer(Long id) {
        if(id == null || id <= 0){
            throw  new IllegalArgumentException("Invalid customer Id");
        }

        customerRepository.findById(id).orElseThrow(()->new RuntimeException("customer id not found "+id));

    }



    public Customer createCustomer(User  user){
        // Customer customer = new Customer().builder();

        // return customerRepository.save(customer );
        return null;

    }


    @Transactional
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    /**
     * new Methods from here
     *
     */

    public Customer findCustomerByEmail(String email){
        if(!ConcreteValidChecker.validString(email)){
            throw  new IllegalArgumentException("email does not exist");
        }
        return customerRepository.findCustomerByEmail(email).orElseThrow(() -> new RuntimeException("email "+email+" does not exist !"));
    }

    public  Customer findCustomerByFirstName(String firstName){
        if(!ConcreteValidChecker.validString(firstName)){
            throw  new IllegalArgumentException("Name does not exist");
        }
        return customerRepository.findCustomerByFirstName(firstName).orElseThrow(()->new RuntimeException("name "+firstName+" does not exist"));
    }

    public Customer findCustomerByLastName(String lastName){
        if(!ConcreteValidChecker.validString(lastName)){
            throw  new IllegalArgumentException("Name does not exist");
        }
        return customerRepository.findCustomerByLastName(lastName).orElseThrow(()->new RuntimeException("last name "+lastName+" does not exist"));
    }


    public Customer findCustomerByCartId(Long id){
        if(!ConcreteValidChecker.validId(id)){
            throw new IllegalArgumentException("Id can not be lesser Than zero!!!");
        }
        return customerRepository.findCustomerByCartId(id).orElseThrow(() -> new RuntimeException("Invalid id"));
    }

    public List<Customer> findCustomerByLessThanAmount(double amount){
        if(!ConcreteValidChecker.greaterZero(amount)){
          throw  new IllegalArgumentException("Amount can not be lesser than zero");
        }
     return customerRepository.findCustomerByLessThanAmount(amount);
    }


    public List<Customer> findCustomerByCity(String cityName){
        if(!ConcreteValidChecker.validString(cityName)){
            throw  new IllegalArgumentException("Invalid city Name!!!");
        }
        return customerRepository.findCustomerByCity(cityName);
    }

    public List<Customer> findCustomerByReview(String bookName,double rate){
        if(!(ConcreteValidChecker.validString(bookName) && ConcreteValidChecker.greaterZero(rate))){
            throw new IllegalArgumentException("either of two invalid!!!");
        }
        return customerRepository.findCustomerByReview(bookName,rate);
    }

}
