package com.ecommerce.onlinebookshop.repository;

import com.ecommerce.onlinebookshop.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface AdminRepository extends  JpaRepository<Customer,Long>{


}