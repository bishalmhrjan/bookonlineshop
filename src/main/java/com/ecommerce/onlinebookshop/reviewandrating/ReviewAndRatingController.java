package com.ecommerce.onlinebookshop.reviewandrating;

import com.ecommerce.onlinebookshop.model.entity.ReviewAndRating;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ReviewAndRating>> getAllCartItems(){
        List<ReviewAndRating> revs= reviewAndRatingService.getAllReviewAndRates();
        return ResponseEntity.ok(revs);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCartItemById(@PathVariable Long id){
        Optional<ReviewAndRating> reviewAndRatingToSave= reviewAndRatingService.getReviewAndRateById(id);
        return reviewAndRatingToSave.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReviewAndRating> createCartItem(@RequestBody ReviewAndRating ReviewAndRating){
        ReviewAndRating reviewAndRatingToSave= reviewAndRatingService.addReviewAndRating(ReviewAndRating);
    return  ResponseEntity.status(HttpStatus.CREATED).body(reviewAndRatingToSave);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id){
        reviewAndRatingService.deleteReviewAndRateById(id);
        return ResponseEntity.noContent().build();
    }
}
