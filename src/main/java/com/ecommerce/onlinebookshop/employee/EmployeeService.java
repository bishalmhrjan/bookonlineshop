package com.ecommerce.onlinebookshop.employee;

import com.ecommerce.onlinebookshop.model.entity.Employee;
import com.ecommerce.onlinebookshop.employee.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    public Employee addEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())){
            throw  new IllegalArgumentException("Employee existed in repo already");
        }
        return employeeRepository.save(employee);
    }


    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employee not found");
        }
        employeeRepository.deleteById(id);
    }

}
