package com.ecommerce.onlinebookshop.employee;

import com.ecommerce.onlinebookshop.model.entity.Adress;
import com.ecommerce.onlinebookshop.model.entity.AuditDetails;
import com.ecommerce.onlinebookshop.model.entity.Permission;
import com.ecommerce.onlinebookshop.model.entity.Security;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {




    private String firstName;
    private String lastName;
    private String email;


    private Adress shippingAddress;


    private Adress billingAddress;

}
