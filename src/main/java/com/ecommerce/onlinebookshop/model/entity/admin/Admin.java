package com.ecommerce.onlinebookshop.model.entity.admin;

import com.ecommerce.onlinebookshop.model.entity.AuditDetails;
import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.model.entity.Permission;
import com.ecommerce.onlinebookshop.model.entity.Security;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class Admin extends Customer {



    private String role;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Permission> permissions;


    @Embedded
    private Security security;

    @Embedded
    private AuditDetails auditDetails;
}
