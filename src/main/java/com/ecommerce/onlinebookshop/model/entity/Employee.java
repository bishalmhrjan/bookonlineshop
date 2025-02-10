package com.ecommerce.onlinebookshop.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private String role;

    private String department;

    private Long managerId;  // Reference to manager

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Permission> permissions;

    @Embedded
    private Security security;

    @Embedded
    private AuditDetails auditDetails;
}
