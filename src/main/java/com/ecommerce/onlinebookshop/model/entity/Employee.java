package com.ecommerce.onlinebookshop.model.entity;

import com.ecommerce.onlinebookshop.authcredentials.AuthCredentials;
import com.ecommerce.onlinebookshop.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "employee")
@DiscriminatorValue("EMPLOYEE")
public class Employee extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String role;

    private String department;

    private Long managerId;  // Reference to manager


    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Permission> permissions;



    private Security security;

    @Embedded
    private AuditDetails auditDetails;
}
