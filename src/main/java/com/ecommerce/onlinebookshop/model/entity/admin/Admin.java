package com.ecommerce.onlinebookshop.model.entity.admin;

import com.ecommerce.onlinebookshop.model.entity.AuditDetails;
import com.ecommerce.onlinebookshop.model.entity.Permission;
import com.ecommerce.onlinebookshop.model.entity.Security;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data //generates Getters, setters, hascode and toString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private String role;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Permission> permissions;


    @Embedded
    private Security security;

    @Embedded
    private AuditDetails auditDetails;
}
