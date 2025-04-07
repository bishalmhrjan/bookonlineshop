package com.ecommerce.onlinebookshop.reviewandrating;

import com.ecommerce.onlinebookshop.reviewandrating.ReviewAndRatingDto;
import com.ecommerce.onlinebookshop.model.entity.ReviewAndRating;

public class ReviewAndRatingMapper {

    public static ReviewAndRatingDto mapToReviewAndRating(ReviewAndRating reviewAndRating){
        ReviewAndRatingDto reviewAndRatingDto = ReviewAndRatingDto.builder()
                .id(reviewAndRating.getId())
                .book(reviewAndRating.getBook())
                .description(reviewAndRating.getDescription())
                .customer(reviewAndRating.getCustomer())
                .build();
        return reviewAndRatingDto;
    }


    public static ReviewAndRating mapToReviewAndRating(ReviewAndRatingDto reviewAndRatingDto){

        ReviewAndRating reviewAndRating =ReviewAndRating.builder()
                .id(reviewAndRatingDto.getId())
                .book(reviewAndRatingDto.getBook())
                .description(reviewAndRatingDto.getDescription())
                .customer(reviewAndRatingDto.getCustomer())
                .build();
        return reviewAndRating;
    }
}
