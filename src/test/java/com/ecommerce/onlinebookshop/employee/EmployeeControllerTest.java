package com.ecommerce.onlinebookshop.employee;

import com.ecommerce.onlinebookshop.admin.AdminService;
import com.ecommerce.onlinebookshop.model.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockitoBean
    private EmployeeService employeeService;

    private final String BASE_URL="/api/employees";

    @Test
    @WithMockUser(username = "admin",roles={"ADMIN","EMPLOYEE"})
    void getAllEmployee() throws Exception {

        Employee employee1 = Employee.builder()
                        .firstName("Bishal")
                        .id(1L)
                 .build();
        Employee employee2 = Employee.builder()
                .firstName("Bishnu")
                .id(2L)
                .build();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

    when(employeeService.getAllEmployees()).thenReturn(employees);
    mockMvc.perform(get(BASE_URL))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.size()").value(2))
            .andExpect(jsonPath("$[0].id").value(1L))
            .andExpect(jsonPath("[0].firstName").value("Bishal"))
            .andExpect(jsonPath("$[1].firstName").value("Bishnu"));
    }

    @Test
    @WithMockUser(username = "admin",roles={"ADMIN","EMPLOYEE"})
    void getEmployeeById() throws Exception{
        Employee employee1 = Employee.builder()
                .firstName("Bishal")
                .id(1L)
                .build();
        Employee employee2 = Employee.builder()
                .firstName("Bishnu")
                .id(2L)
                .build();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        when(employeeService.getEmployeeById(2L)).thenReturn(Optional.of(employee2));
        mockMvc.perform(get(BASE_URL+"/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Bishnu"));


    }

    @Test    @WithMockUser(username = "admin",roles={"ADMIN","EMPLOYEE"})

    void createEmployee_ShouldReturnCreatedEmployee() throws Exception {
        Employee employee1 = Employee.builder()
                .firstName("Bishal")
                .id(1L)
                .build();
        Employee employee2 = Employee.builder()
                .firstName("Bishnu")
                .id(2L)
                .build();
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        when(employeeService.addEmployee(any(Employee.class))).thenReturn(employee1);

        mockMvc.perform(post(BASE_URL)
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("Bishal"));


    }

    @Test
    @WithMockUser(username = "admin",roles={"ADMIN","EMPLOYEE"})
    void getEmployeeById_ShouldReturn404_WhenNotFound() throws  Exception{
        when(employeeService.getEmployeeById(1L)).thenReturn(Optional.empty());
        mockMvc.perform(get(BASE_URL+"/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "admin",roles={"ADMIN","EMPLOYEE"})
    void deleteEmployee_ShouldReturnNoContent() throws Exception {
        doNothing().when(employeeService).deleteEmployee(1L);
        mockMvc.perform(delete(BASE_URL+"/1")
                .with(csrf()))
                .andExpect(status().isNoContent());
        verify(employeeService,times(1)).deleteEmployee(1L);
    }
}