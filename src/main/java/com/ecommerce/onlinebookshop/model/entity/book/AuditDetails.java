package com.ecommerce.onlinebookshop.model.entity.book;

import com.ecommerce.onlinebookshop.model.enums.BookType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data //generates Getters, setters, hascode and toString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AuditDetails {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
