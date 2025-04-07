package com.ecommerce.onlinebookshop.authcredentials;

import com.ecommerce.onlinebookshop.user.User;
import com.ecommerce.onlinebookshop.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AuthService {
    private AuthCredentialsRepository repository;
    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

   @Autowired
   public AuthService(AuthCredentialsRepository repository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public AuthCredentials createCredentials(User user, String username, String password){
       if(repository.existsByUsername(username)){
           throw new IllegalArgumentException("Username already exists");
       }

       AuthCredentials credentials = new AuthCredentials();
       credentials.setUsername(username);

        credentials.setPassword(passwordEncoder.encode(password));

       credentials.setUser(user);
       return repository.save(credentials);
    }

    public  void  updatePassword(Long userId, String newPassword){
       AuthCredentials credentials = repository.findById(userId)
               .orElseThrow(()->new EntityNotFoundException("Credentials not found"));

       credentials.setPassword(passwordEncoder.encode(newPassword));
       repository.save(credentials);
    }

    public void toggleAccountStatus(Long userId){
       AuthCredentials credentials = repository.findById(userId)
               .orElseThrow(()->new EntityNotFoundException("Credential not Found!!!"));

        repository.save(credentials);
    }
    public Optional<User> findByUsername(String username){
       return repository.findByUsername(username)
               .map(AuthCredentials :: getUser);
    }
}
