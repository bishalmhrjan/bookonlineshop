package com.ecommerce.onlinebookshop.employee;

import com.ecommerce.onlinebookshop.model.entity.Employee;
import com.ecommerce.onlinebookshop.model.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface EmployeeRepository extends JpaRepository<Employee,Long> {
/**
 * jpql for first,lastname
 */
@Query("SELECT e FROM Employee e WHERE e.email = :email")
List<Employee> findEmployeeByEmail(@Param("email") String email);

 @Query("SELECT  e FROM Employee e WHERE e.firstName = :firstName")
 List<Employee> findEmployeeByFirstName(@Param("firstName") String firstName);

 @Query("SELECT e FROM Employee e WHERE e.lastName= :lastName")
 List<Employee> findEmployeeByLastName(@Param("lastName") String lastName);



 @Query("SELECT  e FROM Employee e WHERE e.shippingAddress.cityName = :city")
 List<Employee> findEmployeeByCity(@Param("city") String city);


}
