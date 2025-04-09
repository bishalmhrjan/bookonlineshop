package com.ecommerce.onlinebookshop.customer;

import com.ecommerce.onlinebookshop.model.entity.Cart;
import com.ecommerce.onlinebookshop.model.entity.Customer;
import com.ecommerce.onlinebookshop.model.entity.Employee;
import com.ecommerce.onlinebookshop.model.entity.Order;
import com.ecommerce.onlinebookshop.model.entity.admin.Admin;
import com.ecommerce.onlinebookshop.model.entity.book.Book;
import com.ecommerce.onlinebookshop.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Optional<Customer> findCustomerByEmail(@Param("email") String email);

    @Query("SELECT c FROM Customer c WHERE c.firstName = :firstName")
    Optional<Customer> findCustomerByFirstName(@Param("firstName") String firstName);

    @Query("SELECT c FROM Customer c WHERE c.lastName= :lastName")
    Optional<Customer> findCustomerByLastName(@Param("lastName") String lastName);


    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.cart WHERE c.cart.id= :cartId")
    Optional<Customer> findCustomerByCartId(@Param("cartId") Long cartId);


    @Query("SELECT c FROM Customer c WHERE c.shippingAddress.cityName = :city")
    List<Customer> findCustomerByCity(@Param("city") String city);


    @Query("SELECT c FROM Customer c   JOIN FETCH c.orders o WHERE o.amount <= :amount")
    List<Customer> findCustomerByLessThanAmount(@Param("amount") double amount);

    @Query("SELECT DISTINCT c FROM Customer c " +
            "JOIN   c.reviewAndRatings r " +
            "JOIN r.book b " +
            "WHERE r.rate <= :rate AND b.title = :title")
    List<Customer> findCustomerByReview(
            @Param("title") String bookName,
            @Param("rate") double rate);
}
