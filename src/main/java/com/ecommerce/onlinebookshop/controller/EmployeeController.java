package com.ecommerce.onlinebookshop.controller;

import com.ecommerce.onlinebookshop.model.entity.Employee;
import com.ecommerce.onlinebookshop.service.EmployeeService;
import com.ecommerce.onlinebookshop.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class EmployeeController {
    private final EmployeeService EmployeeService;



    public EmployeeController(EmployeeService cartItemItemService) {
        this.EmployeeService = cartItemItemService;
    }

    @GetMapping
    public List<Employee> getAllCartItems(){
        return EmployeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getCartItemById(@PathVariable Long id){
        return EmployeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createCartItem(@RequestBody Employee Employee){
        return EmployeeService.addEmployee(Employee);
    }

    @DeleteMapping
    public void deleteCartItem(@PathVariable Long id){
        EmployeeService.deleteEmployee(id);
    }
}
