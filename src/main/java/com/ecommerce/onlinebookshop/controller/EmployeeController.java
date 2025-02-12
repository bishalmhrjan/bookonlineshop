package com.ecommerce.onlinebookshop.controller;

import com.ecommerce.onlinebookshop.model.entity.Employee;
import com.ecommerce.onlinebookshop.service.EmployeeService;
import com.ecommerce.onlinebookshop.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;



    public EmployeeController(EmployeeService cartItemItemService) {
        this.employeeService = cartItemItemService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllCartItems(){
        List<Employee> employees= employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getCartItemById(@PathVariable Long id){
        Optional<Employee> employee= employeeService.getEmployeeById(id);
      return   employee.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound()
        .build());
    }

    @PostMapping
    public ResponseEntity<Employee> createCartItem(@RequestBody Employee employee){
        Employee employeeToSave = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeToSave);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
