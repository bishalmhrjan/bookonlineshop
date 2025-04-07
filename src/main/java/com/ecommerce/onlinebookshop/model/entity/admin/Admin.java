package com.ecommerce.onlinebookshop.model.entity.admin;

import com.ecommerce.onlinebookshop.authcredentials.AuthCredentials;
import com.ecommerce.onlinebookshop.model.entity.*;
import com.ecommerce.onlinebookshop.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data //generates Getters, setters, hascode and toString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    private String role; //???

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Permission> permissions;


    @Embedded
    private Security security;

}
