package com.ecommerce.onlinebookshop.user;

import com.ecommerce.onlinebookshop.model.entity.Adress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)

@Data //generates Getters, setters, hascode and toString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public   class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "shipping_street")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "shipping_postal_code")),
            @AttributeOverride(name = "cityName", column = @Column(name = "shipping_city"))
    })
    private Adress shippingAddress;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetName", column = @Column(name = "billing_street")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "billing_postal_code")),
            @AttributeOverride(name = "cityName", column = @Column(name = "billing_city"))
    })
    private Adress billingAddress;   // Other profile fields
}
