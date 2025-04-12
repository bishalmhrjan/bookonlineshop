package com.ecommerce.onlinebookshop.admin;

import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.model.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends  JpaRepository<Admin,Long>{

    @Query("SELECT a FROM Admin a WHERE a.email = :email")
    List<Admin> findAdminByEmail(@Param("email") String email);

    @Query("SELECT  a FROM Admin a WHERE a.firstName = :firstName")
    List<Admin> findAdminByFirstName(@Param("firstName") String firstName);

    @Query("SELECT a FROM Admin a WHERE a.lastName= :lastName")
    List<Admin> findAdminByLastName(@Param("lastName") String lastName);



    @Query("SELECT  a FROM Admin a WHERE  a.shippingAddress.cityName = :city")
    List<Admin> findAdminByCity(@Param("city") String city);







}