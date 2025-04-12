package com.ecommerce.onlinebookshop.cart;

import com.ecommerce.onlinebookshop.model.entity.Cart;
import com.ecommerce.onlinebookshop.model.entity.Order;
import com.ecommerce.onlinebookshop.model.entity.book.Book;
import com.ecommerce.onlinebookshop.model.enums.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    @Query("SELECT c FROM Cart c WHERE c.totalPrice <= :totalPrice")
    List<Cart> findCartLesserThantotalPrice(@Param("totalPrice") double totalPrice);


    @Query("SELECT  c FROM Cart c WHERE c.customer.firstName = :firstName")
    List<Cart> findCartByCustomerFirstName(@Param("firstName")  String firstName);


}
