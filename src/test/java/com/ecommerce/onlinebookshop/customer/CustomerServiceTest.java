package com.ecommerce.onlinebookshop.customer;

import com.ecommerce.onlinebookshop.model.entity.Adress;
import com.ecommerce.onlinebookshop.model.entity.Cart;
import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.model.entity.Order;
import com.ecommerce.onlinebookshop.user.User;
import org.aspectj.weaver.ast.Or;
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
  class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void deleteCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        List<Customer> customers = listCustomer();
        listCustomer().add(customer);

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> expCustomer = customerService.getAllCustomer();

        customerService.deleteCustomer(1L);

        verify(customerRepository,times(1)).deleteById(1L);
            }


    @Test
    void addCustomer() {
        Customer customer = new Customer();
        List<Customer> customers = listCustomer();
        customers.add(customer);

        customerService.addCustomer(customer);

        verify(customerRepository, times(1)).save(customer);

    }

    @Test
    void getCustomerById() {
        Long id = 1L;
        Customer customer = new Customer();
        customer.setId(id);
        when(customerRepository.findById(id)).thenReturn(Optional.of(customer));

        Optional<Customer> expCustomer = customerService.getCustomerById(id);
        assertTrue(expCustomer.isPresent());
        verify(customerRepository,times(1)).findById(id);


    }

    @Test
    void findCustomerByEmail() {
        String email ="three@example.com";
        Customer customer = new Customer();
        customer.setEmail(email);

        when(customerRepository.findCustomerByEmail(email)).thenReturn(Optional.of(customer));

        Customer expCustomer = customerService.findCustomerByEmail(email);
        assertNotNull(expCustomer);
        assertEquals(email,expCustomer.getEmail());
        verify(customerRepository,times(1)).findCustomerByEmail(email);
    }

    @Test
    void findCustomerByFirstName() {
        String firstName ="Bishal";
        Customer customer = new Customer();
        customer.setFirstName(firstName);

        when(customerRepository.findCustomerByFirstName(firstName)).thenReturn(Optional.of(customer));

        Customer expCustomer = customerService.findCustomerByFirstName(firstName);
        assertNotNull(expCustomer);
        assertEquals(firstName,expCustomer.getFirstName());
        verify(customerRepository,times(1)).findCustomerByFirstName(firstName);
    }

    @Test
    void findCustomerByLastName() {
        String lastName ="Maharjan";
        Customer customer = new Customer();
        customer.setLastName(lastName);

        when(customerRepository.findCustomerByLastName(lastName)).thenReturn(Optional.of(customer));

        Customer expCustomer = customerService.findCustomerByLastName(lastName);

        assertNotNull(expCustomer);
        assertEquals(lastName,expCustomer.getLastName());
        verify(customerRepository,times(1)).findCustomerByLastName(lastName);
    }

    @Test
    void findCustomerByCartId() {
        Long id=1L;
        Customer customer = new Customer();
        Cart cart = new Cart();
        cart.setId(id);
        customer.setCart(cart);

        when(customerRepository.findCustomerByCartId(id)).thenReturn(Optional.of(customer));

        Customer expCustomer = customerService.findCustomerByCartId(id);

        assertNotNull(expCustomer);
        assertEquals(id,expCustomer.getCart().getId());
        verify(customerRepository,times(1)). findCustomerByCartId(id);
    }

    @Test
    void findCustomerByLessThanAmount() {
        double amount = 200;
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();

        Order order1 = new Order();
        order1.setAmount(100);
        Order order2 = new Order();
        order2.setAmount(150);

        Order order3 = new Order();
        order3.setAmount(100);

        List<Order> orders1= new ArrayList<>();
        List<Order> orders2= new ArrayList<>();
        orders1.add(order1);
        orders1.add(order2);

        customer1.setOrders(orders1);
        customer2.setOrders(orders2);

        orders2.add(order3);


        List<Customer> customers = List.of(new Customer( ), new Customer( ));

        when(customerRepository.findCustomerByLessThanAmount(amount)).thenReturn(customers);
        List<Customer> customersExpected = customerService.findCustomerByLessThanAmount(amount);

        assertEquals(2,customersExpected.size());
        assertNotNull(customersExpected);
        verify(customerRepository,times(1)). findCustomerByLessThanAmount(amount);
    }

    @Test
    void findCustomerByCity() {

        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();


        String city1="Karlsruhe";
        String city2="Hamburg";
        String city3="Berlin";

        Adress adress1= new Adress();
        Adress adress2= new Adress();
        Adress adress3= new Adress();

        adress1.setCityName(city1);
        adress2.setCityName(city2);
        adress3.setCityName(city3);

        customer1.setShippingAddress(adress1);
        customer2.setShippingAddress(adress2);
        customer3.setShippingAddress(adress3);

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        when(customerRepository.findCustomerByCity(city1)).thenReturn(customers);
        List<Customer> result =customerService.findCustomerByCity(city1);

        assertEquals(city1,result.get(0).getShippingAddress().getCityName());
        verify(customerRepository,times(1)).findCustomerByCity(city1);

    }

    @Test
    void findCustomerByReview() {
        // need to implement it later
    }

    public List<Customer> listCustomer(){
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        return customers;
    }
}