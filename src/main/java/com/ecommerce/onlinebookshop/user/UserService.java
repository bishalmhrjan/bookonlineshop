package com.ecommerce.onlinebookshop.user;

import com.ecommerce.onlinebookshop.model.entity.admin.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(email));
    }

    public List<User> getAllAdmins(){
        return userRepository.findAllByType(Admin.class);
    }

    public boolean emailExists(String email){
        return userRepository.existsByEmail(email);
    }
}
