package com.ecommerce.onlinebookshop.user;

import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.model.entity.Employee;
import com.ecommerce.onlinebookshop.model.entity.admin.Admin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
  class UserServiceTest {

    @Mock
    private UserRepository userRepository;
   @InjectMocks
   private UserService userService;

    @Test
    void getAllAdmins(){

        List<Admin> admins = List.of(new Admin(), new Admin());
        when(userRepository.findAllByType(Admin.class)).thenReturn(admins);
        List<Admin>  actualAdmins = userService.getAllAdmins();

        assertEquals(2,actualAdmins.size());
     }

    @Test
    void emailExist(){
        String email ="three@example.com";

        /**

         User user1 = new User();
         user1.setEmail("one@example.com");
         User user2 = new User();
         user2.setEmail("two@example.com");
         User user3 = new User();
         user3.setEmail("three@example.com");
         */

         when(userRepository.existsByEmail(email)).thenReturn(true);
        boolean emailExists = userService.emailExists(email);
        assertTrue(emailExists);
    }

    @Test
    void getUserByEmail(){
        String email ="three@example.com";

        User user1 = new Customer();
        user1.setEmail("one@example.com");
        User user2 = new Employee();
        user2.setEmail("two@example.com");
        User user3 = new Admin();
        user3.setEmail("three@example.com");

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user3));
        Optional<User> userWithEmail = userService.getUserByEmail(email);

        assertTrue(userWithEmail.isPresent());
        verify(userRepository,times(1)).findByEmail(email);
    }


}