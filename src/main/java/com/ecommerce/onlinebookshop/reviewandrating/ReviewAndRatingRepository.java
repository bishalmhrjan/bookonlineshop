package com.ecommerce.onlinebookshop.reviewandrating;

import com.ecommerce.onlinebookshop.model.entity.ReviewAndRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewAndRatingRepository extends JpaRepository<ReviewAndRating,Long> {
}
