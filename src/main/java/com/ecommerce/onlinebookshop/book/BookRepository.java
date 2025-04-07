package com.ecommerce.onlinebookshop.book;

import com.ecommerce.onlinebookshop.model.entity.book.Book;
import com.ecommerce.onlinebookshop.model.enums.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT b from Book where b.price < :maxPrice")
    List<Book> findBookBelowPrice(@Param ("maxPrice")double maxPrice);

    @Query("SELECT b from Book where b.auditDetails.createdAt = :createdAt")
    List<Book> findBookInStoreAfter(@Param("createdAt") LocalDate localDate);

    @Query("SELECT b from Book where b.category = :category")
    List<Book> findBookByCategory(@Param("category") BookType bookType);

    @Query("SELECT b from Book where b.stockquantity < : threshold")
    List<Book> findLowStockBooks(@Param("threshold") int threshold);

    @Query("SELECT b from Book b where b.description.description LIKE %:keyword%")
    List<Book> findBookDescriptionContaing(@Param("keyword") String keyword);

    @Modifying
    @Query("UPDATE book b SET b.stockquantity + :quantity where b.id= :id")
    void restockBook(@Param("id")Long id, @Param("quantity") int quantity);

    @Query("SELECT b from Book where b.bookMetaData.author = :author ")
    List<Book> findBookByAuthor(@Param("author") String author);

    @Query("SELECT b from Book where b.bookMetaData.publisher : publisher")
    List<Book> findBookByPublisher(@Param("publisher") String publisher);
}
