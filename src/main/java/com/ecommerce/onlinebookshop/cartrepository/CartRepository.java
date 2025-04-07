package com.ecommerce.onlinebookshop.cartrepository;

import com.ecommerce.onlinebookshop.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
