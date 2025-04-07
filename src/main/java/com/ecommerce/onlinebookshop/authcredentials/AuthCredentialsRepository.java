package com.ecommerce.onlinebookshop.authcredentials;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AuthCredentialsRepository extends JpaRepository<AuthCredentials, Long> {

    Optional<AuthCredentials> findByUsername(String username);

    Optional<AuthCredentials> findByEmail(String email);

    boolean existsByUsername(String username);

    @Modifying
    @Transactional
    @Query("UPDATE AuthCredentials a SET a.password = :newPassword WHERE a.id = :id")
    int updatePassword(@Param("id") Long id, @Param("newPassword") String newPassword);


    // Example: Update email if you ever need it
    @Modifying
    @Transactional
    @Query("UPDATE AuthCredentials a SET a.email = :email WHERE a.id = :id")
    int updateEmail(@Param("id") Long id, @Param("email") String email);

}
