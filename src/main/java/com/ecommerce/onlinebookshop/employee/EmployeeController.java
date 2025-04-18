package com.ecommerce.onlinebookshop.employee;

import com.ecommerce.onlinebookshop.model.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@PreAuthorize("hasanyRole('ADMIN','EMPLOYEE')")
public class EmployeeController {
    private final EmployeeService employeeService;



    public EmployeeController(EmployeeService cartItemItemService) {
        this.employeeService = cartItemItemService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> employees= employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> geEmployeeById(@PathVariable Long id){
        Optional<Employee> employee= employeeService.getEmployeeById(id);
      return   employee.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound()
        .build());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee employeeToSave = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeToSave);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
