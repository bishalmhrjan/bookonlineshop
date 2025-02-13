package com.ecommerce.onlinebookshop.dto;

import com.ecommerce.onlinebookshop.model.entity.Adress;
import com.ecommerce.onlinebookshop.model.entity.Permission;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class AdminDto {
    private String firstName;
    private String lastName;
    private String email;


    private Adress shippingAddress;


    private Adress billingAddress;



}
