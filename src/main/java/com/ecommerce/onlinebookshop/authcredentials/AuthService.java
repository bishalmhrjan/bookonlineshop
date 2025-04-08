package com.ecommerce.onlinebookshop.authcredentials;

import com.ecommerce.onlinebookshop.user.User;
import com.ecommerce.onlinebookshop.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; // Import the PasswordEncoder
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AuthService {
    private AuthCredentialsRepository repository;
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;
    @Autowired
    public AuthService(AuthCredentialsRepository repository, UserRepository userRepository,PasswordEncoder passwordEncoder) { // Add PasswordEncoder to constructor
        this.repository = repository;
        this.userRepository = userRepository;
        this.passwordEncoder= passwordEncoder;
     }

    public AuthCredentials createCredentials(User user, String username, String password) {
        if (repository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already exists");
        }

        AuthCredentials credentials = new AuthCredentials();
        credentials.setUsername(username);
        credentials.setPassword(passwordEncoder.encode(password)); // Use passwordEncoder here

        credentials.setUser(user);
        return repository.save(credentials);
    }

    public void updatePassword(Long userId, String newPassword) {
        AuthCredentials credentials = repository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Credentials not found"));

        credentials.setPassword(passwordEncoder.encode(newPassword)); // Use passwordEncoder here
        repository.save(credentials);
    }

    public void toggleAccountStatus(Long userId) {
        AuthCredentials credentials = repository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Credential not Found!!!"));

        repository.save(credentials);
    }

    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username)
                .map(AuthCredentials::getUser);
    }
}