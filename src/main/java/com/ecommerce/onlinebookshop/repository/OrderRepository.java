package com.ecommerce.onlinebookshop.repository;

import com.ecommerce.onlinebookshop.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface OrderRepository extends JpaRepository<Order,Long> {
}
