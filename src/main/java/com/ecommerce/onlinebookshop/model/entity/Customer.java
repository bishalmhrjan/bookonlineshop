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
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@DiscriminatorValue("CUSTOMER")

public class Customer extends User {



    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Order> orders;

    @OneToOne
    private Cart cart;
    private Security security;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ReviewAndRating> reviewAndRatings;

    @Embedded
    private AuditDetails auditDetails;

}
