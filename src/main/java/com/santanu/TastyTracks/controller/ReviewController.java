package com.santanu.TastyTracks.controller;

import com.santanu.TastyTracks.Exception.ReviewException;
import com.santanu.TastyTracks.Exception.UserException;
import com.santanu.TastyTracks.model.Review;
import com.santanu.TastyTracks.model.User;
import com.santanu.TastyTracks.request.ReviewRequest;
import com.santanu.TastyTracks.service.ReviewService;
import com.santanu.TastyTracks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;

    @PostMapping("/review")
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequest review, @RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        Review submitedReview = reviewService.submitReview(review, user);
        return ResponseEntity.ok(submitedReview);
    }


    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) throws ReviewException {
        reviewService.deleteReview(reviewId);
        return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/average-rating")
    public ResponseEntity<Double> calculateAverageRating(@RequestBody List<Review> reviews) {
        double averageRating = reviewService.calculateAverageRating(reviews);
        return new ResponseEntity<>(averageRating, HttpStatus.OK);
    }
}