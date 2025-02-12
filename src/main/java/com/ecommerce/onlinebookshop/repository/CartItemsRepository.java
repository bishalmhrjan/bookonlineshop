package com.ecommerce.onlinebookshop.repository;

import com.ecommerce.onlinebookshop.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItem,Long> {
}
