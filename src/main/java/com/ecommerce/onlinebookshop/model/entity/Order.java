package com.ecommerce.onlinebookshop.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //generates Getters, setters, hascode and toString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private double amount;

    @Embedded

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



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
