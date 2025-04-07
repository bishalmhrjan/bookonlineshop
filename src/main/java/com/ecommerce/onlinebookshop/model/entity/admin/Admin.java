package com.ecommerce.onlinebookshop.model.entity.admin;

import com.ecommerce.onlinebookshop.model.entity.*;
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
public class Admin extends AuthCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String role; //???

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Permission> permissions;


    @Embedded
    private Security security;

    @JoinColumn(name="user_id",referencedColumnName = "id")
    private AuditDetails auditDetails;

}
