package com.ecommerce.onlinebookshop.mapper;

import com.ecommerce.onlinebookshop.dto.AdminDto;
import com.ecommerce.onlinebookshop.exception.InvalidAdminException;
import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.model.entity.admin.Admin;

public class AdminMapper extends Customer {
    public  static AdminDto mapToAdminDto(Admin admin) throws InvalidAdminException {
        if(admin==null){

            throw new InvalidAdminException("Admin is null");
        }

        AdminDto adminDto = AdminDto.builder()
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .email(admin.getEmail())
                .shippingAddress(admin.getShippingAddress())
                .billingAddress(admin.getBillingAddress())
                .build();

    return  adminDto;
    }


    public static Admin mapToAdmin(AdminDto adminDto) throws InvalidAdminException {
        if(adminDto==null){
            throw new InvalidAdminException("Admin is null");
        }
        Admin admin = Admin.builder()
                .firstName(adminDto.getFirstName())
                .lastName(adminDto.getLastName())
                .email(adminDto.getEmail())
                .shippingAddress(adminDto.getShippingAddress())
                .billingAddress(adminDto.getBillingAddress())
                .build();
        return admin;
    }
}
