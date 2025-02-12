package com.ecommerce.onlinebookshop.repository;

import com.ecommerce.onlinebookshop.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
