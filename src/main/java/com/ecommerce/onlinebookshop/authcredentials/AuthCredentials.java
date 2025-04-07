package com.ecommerce.onlinebookshop.authcredentials;

import com.ecommerce.onlinebookshop.model.entity.Adress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class AuthCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

}
