package com.ecommerce.onlinebookshop.customer;

import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.ManyToOne;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
@WithMockUser(username = "admin", roles={"ADMIN"})

class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CustomerService customerService;

    private final String BASE_URL="/api/customers";

    @Test

    void getCustomerById() throws Exception {
        Customer customer1 = Customer.builder()
                .firstName("Simon")
                .id(1L).build();
        Customer customer2 = Customer.builder()
                .firstName("Nicolas")
                .id(2L).build();
        Customer customer3 = Customer.builder()
                .firstName("Gabriel")
                .id(3L).build();

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        when(customerService.getCustomerById(1L)).thenReturn(Optional.of(customer1));

        mockMvc.perform(get(BASE_URL+"/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.firstName").value("Simon"));



    }

    @Test
    void createCustomer() throws Exception {
        Customer customer1 = Customer.builder()
                .firstName("Simon")
                .id(1L).build();
        Customer customer2 = Customer.builder()
                .firstName("Nicolas")
                .id(2L).build();
        Customer customer3 = Customer.builder()
                .firstName("Gabriel")
                .id(3L).build();

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

        when(customerService.addCustomer(any(Customer.class))).thenReturn(customer3);
        mockMvc.perform(post(BASE_URL)
                .with(csrf()).contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer3)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.firstName").value("Gabriel"));
        verify(customerService,times(1)).addCustomer(customer3);


    }

    @Test
    @WithMockUser( roles="ADMIN")

    void deleteCustomer() throws Exception {
        doNothing().when(customerService).deleteCustomer(1L);
        mockMvc.perform(delete(BASE_URL+"/1")
                        .with(csrf()))

                .andExpect(status().isNoContent());
        verify(customerService,times(1)).deleteCustomer(1L);
    }
}