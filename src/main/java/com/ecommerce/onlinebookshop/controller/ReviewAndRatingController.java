package com.ecommerce.onlinebookshop.controller;

import com.ecommerce.onlinebookshop.model.entity.ReviewAndRating;
import com.ecommerce.onlinebookshop.service.ReviewAndRatingService;
import com.ecommerce.onlinebookshop.service.ReviewAndRatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviewandrates")
public class ReviewAndRatingController {
    private final ReviewAndRatingService reviewAndRatingService;



    public ReviewAndRatingController(ReviewAndRatingService reviewAndRatingService) {
        this.reviewAndRatingService = reviewAndRatingService;
    }

    @GetMapping
    public List<ReviewAndRating> getAllCartItems(){
        return reviewAndRatingService.getAllReviewAndRates();
    }

    @GetMapping("/{id}")
    public Optional<ReviewAndRating> getCartItemById(@PathVariable Long id){
        return reviewAndRatingService.getReviewAndRateById(id);
    }

    @PostMapping
    public ReviewAndRating createCartItem(@RequestBody ReviewAndRating ReviewAndRating){
        return reviewAndRatingService.addReviewAndRating(ReviewAndRating);
    }

    @DeleteMapping
    public void deleteCartItem(@PathVariable Long id){
        reviewAndRatingService.deleteReviewAndRateById(id);
    }
}
