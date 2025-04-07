package com.ecommerce.onlinebookshop.book;

import com.ecommerce.onlinebookshop.model.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
