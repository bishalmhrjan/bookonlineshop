package com.ecommerce.onlinebookshop.service;

import com.ecommerce.onlinebookshop.model.entity.ReviewAndRating;
import com.ecommerce.onlinebookshop.reviewandrating.ReviewAndRatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewAndRatingService {
    private final ReviewAndRatingRepository reviewAndRatingRepository;

    public ReviewAndRatingService(ReviewAndRatingRepository reviewAndRatingRepository) {
        this.reviewAndRatingRepository = reviewAndRatingRepository;
    }

    public List<ReviewAndRating> getAllReviewAndRates(){
        return reviewAndRatingRepository.findAll();
    }


    public Optional<ReviewAndRating> getReviewAndRateById(Long id){
        return reviewAndRatingRepository.findById(id);
    }

    public ReviewAndRating addReviewAndRating(ReviewAndRating reviewAndRating){
        return reviewAndRatingRepository.save(reviewAndRating);
    }

    public void deleteReviewAndRateById(Long id){
        reviewAndRatingRepository.deleteById(id);
    }
}
