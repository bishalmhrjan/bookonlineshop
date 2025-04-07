package com.ecommerce.onlinebookshop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@DiscriminatorValue("CUSTOMER")

public class Customer extends AuthCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;



    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Order> orders;

    @OneToOne
    private Cart cart;
     private Security security;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ReviewAndRating> reviewAndRating;

    @JoinColumn(name="user_id",referencedColumnName = "id")
    private AuditDetails auditDetails;

}
