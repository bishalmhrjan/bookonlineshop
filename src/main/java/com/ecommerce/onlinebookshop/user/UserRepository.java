package com.ecommerce.onlinebookshop.user;

import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.model.entity.Employee;
import com.ecommerce.onlinebookshop.model.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query("SELECT c FROM User c WHERE c.email = :email")
    Optional<Customer> findCustomerByEmail(@Param("email") String email);

    @Query("SELECT a FROM Admin a WHERE a.email = :email")
    Optional<Admin> findAdminByEmail(@Param("email") String email);

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Optional<Employee> findEmployeeByEmail(@Param("email") String email);

    boolean existsByEmail(String email);  // Corrected method name

    @Query("SELECT u FROM User u WHERE TYPE(u) = :userType")
    List<User> findAllByType(@Param("userType") Class<? extends User> userType);
}
