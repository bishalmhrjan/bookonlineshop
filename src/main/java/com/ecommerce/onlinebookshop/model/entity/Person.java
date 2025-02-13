package com.ecommerce.onlinebookshop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

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
    private Adress billingAddress;
}
