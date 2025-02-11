package com.ecommerce.onlinebookshop.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "security")
public class Security {

    private String password;
    private LocalDateTime lastPasswordUpdate;

}
