package com.ecommerce.onlinebookshop.book;

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
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT b FROM Book b WHERE b.price < :maxPrice")
    List<Book> findBookBelowPrice(@Param("maxPrice") double maxPrice);

    @Query("SELECT b FROM Book b WHERE b.auditDetails.createdAt > :createdAt")
    List<Book> findBookInStoreAfter(@Param("createdAt") LocalDate createdAt);

    @Query("SELECT b FROM Book b WHERE b.category = :category")
    List<Book> findBookByCategory(@Param("category") BookType bookType);

    @Query("SELECT b FROM Book b WHERE b.stockQuantity < :threshold")
    List<Book> findLowStockBooks(@Param("threshold") int threshold);

    @Query("SELECT b FROM Book b WHERE b.description.description LIKE %:keyword%")
    List<Book> findBookDescriptionContainig(@Param("keyword") String keyword);

    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.stockQuantity = b.stockQuantity + :quantity WHERE b.id= :id")
    void restockBook(@Param("id") Long id, @Param("quantity") int quantity);

    @Query("SELECT b FROM Book b WHERE b.bookMetaData.author = :author")
    List<Book> findBookByAuthor(@Param("author") String author);

    @Query("SELECT b FROM Book b WHERE b.bookMetaData.publisher = :publisher")
    List<Book> findBookByPublisher(@Param("publisher") String publisher);

}
