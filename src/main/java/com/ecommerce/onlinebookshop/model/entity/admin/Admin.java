package com.ecommerce.onlinebookshop.model.entity.admin;

import com.ecommerce.onlinebookshop.model.entity.book.AuditDetails;
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
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private String role;

    @ElementCollection
    private List<String> permissions;

    @Embedded
    private AdminSecurity security;

    @Embedded
    private AuditDetails auditDetails;
}
