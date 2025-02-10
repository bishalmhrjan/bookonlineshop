package com.ecommerce.onlinebookshop.model.entity.admin;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminSecurity {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
