package com.ecommerce.onlinebookshop.model.entity;

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
public class Employee extends AuthCredentials {
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


    @Embedded
    private Security security;
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private AuditDetails auditDetails;
}
