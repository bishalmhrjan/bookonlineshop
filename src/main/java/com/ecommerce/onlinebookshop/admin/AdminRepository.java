package com.ecommerce.onlinebookshop.admin;

import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.model.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends  JpaRepository<Admin,Long>{
// findbyEmail
    Optional<Admin> findByEmail(String email);



}