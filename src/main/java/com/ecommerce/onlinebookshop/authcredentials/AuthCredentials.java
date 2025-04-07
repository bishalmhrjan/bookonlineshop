package com.ecommerce.onlinebookshop.authcredentials;

import jakarta.persistence.*;

public class AuthCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private com.ecommerce.onlinebookshop.model.entity.AuthCredentials person;
}
