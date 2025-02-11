package com.ecommerce.onlinebookshop.model.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //generates Getters, setters, hascode and toString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
 public class Adress {


    private String streetName;
    private int postalCode;
    private String cityName;

}
