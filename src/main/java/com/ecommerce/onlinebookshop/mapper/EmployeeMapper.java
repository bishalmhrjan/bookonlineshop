package com.ecommerce.onlinebookshop.mapper;

import com.ecommerce.onlinebookshop.dto.EmployeeDto;
import com.ecommerce.onlinebookshop.model.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){

        EmployeeDto employeeDto = EmployeeDto.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .shippingAddress(employee.getShippingAddress())
                .billingAddress(employee.getBillingAddress())
                .build();
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = Employee.builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .shippingAddress(employeeDto.getShippingAddress())
                .billingAddress(employeeDto.getBillingAddress())
                .build();
        return employee;
    }
}
