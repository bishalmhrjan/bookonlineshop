package com.ecommerce.onlinebookshop.order;

import com.ecommerce.onlinebookshop.model.entity.Employee;
import com.ecommerce.onlinebookshop.model.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
 public interface OrderRepository extends JpaRepository<Order,Long> {

 /**
  *  order by amount, greater, lesser
  *  order short by Adress( city name)
  *  order sort by Customer name
  */
 @Query("SELECT o FROM Order o WHERE o.amount <= :amount")
 List<Order> findOrderLesserThanAmount(@Param("amount") double amount);

 @Query("SELECT o FROM Order o WHERE o.amount >= :amount")
 List<Order> findOrderGreaterThanAmount(@Param("amount") double amount);


 @Query("SELECT   o FROM Order o WHERE o.shippingAddress.cityName = :city")
 List<Order> findOrderByCity(@Param("city") String city);

 @Query("SELECT   o FROM Order o WHERE o.customer.firstName = :firstName")
 List<Order> findOrderByCustomerFirstName(@Param("firstName")  String firstName);


}
