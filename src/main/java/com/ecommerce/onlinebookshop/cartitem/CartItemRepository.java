package com.ecommerce.onlinebookshop.cartitem;

import com.ecommerce.onlinebookshop.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {

}

