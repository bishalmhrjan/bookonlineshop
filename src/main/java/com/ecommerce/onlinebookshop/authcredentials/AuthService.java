package com.ecommerce.onlinebookshop.authcredentials;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService {
    private AuthCredentialsRepository repository;
    private PasswordEncoder passwordEncoder;



}
