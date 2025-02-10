package com.ecommerce.onlinebookshop.model.entity.book;

import com.ecommerce.onlinebookshop.model.enums.BookType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Embeddable
public class AuditDetails {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
