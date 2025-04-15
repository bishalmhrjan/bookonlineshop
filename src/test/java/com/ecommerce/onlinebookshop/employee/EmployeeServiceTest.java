package com.ecommerce.onlinebookshop.employee;

import com.ecommerce.onlinebookshop.model.entity.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee e = new Employee();
        Employee e2 = new Employee();

        employees.add(e);
        employees.add(e2);


        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(2,result.size());

    }

    @Test
    void getEmployeeById() {
        List<Employee> employees = new ArrayList<>();
        Employee e = new Employee();
        e.setId(1L);
        Employee e2 = new Employee();
        e2.setId(2L);

        employees.add(e);
        employees.add(e2);

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(e));
        Optional<Employee> employee = employeeService.getEmployeeById(1l);

        assertTrue(employee.isPresent());

        assertEquals(1L,employee.get().getId());

    }

    @Test
    void addEmployee() {
        List<Employee> employees = new ArrayList<>();
        Employee e = new Employee();
         Employee e2 = new Employee();

        employees.add(e);
        employees.add(e2);
        when(employeeRepository.save(e)).thenReturn(e);

        Employee result = employeeService.addEmployee(e);

        assertNotNull(result);

     verify(employeeRepository,times(1)).save(e);

    }

    @Test
    void deleteEmployeeById_ShouldCallDeleteById_WhenExists() {
        Long employeeId = 1L;
        when(employeeRepository.existsById(employeeId)).thenReturn(true);
        doNothing().when(employeeRepository).deleteById(employeeId);

        employeeService.deleteEmployee(employeeId);

        verify(employeeRepository).existsById(employeeId);
        verify(employeeRepository).deleteById(employeeId);
    }

    @Test
    void deleteEmployeeById_ShouldThrow_WhenNotExists() {
        Long employeeId = 99L;
        when(employeeRepository.existsById(employeeId)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () -> {
            employeeService.deleteEmployee(employeeId);
        });
    }
}