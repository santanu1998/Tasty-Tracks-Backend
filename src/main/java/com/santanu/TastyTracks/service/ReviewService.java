package com.santanu.TastyTracks.service;

import com.santanu.TastyTracks.Exception.ReviewException;
import com.santanu.TastyTracks.model.Review;
import com.santanu.TastyTracks.model.User;
import com.santanu.TastyTracks.request.ReviewRequest;

import java.util.List;

public interface ReviewService {

    public Review submitReview(ReviewRequest review, User user);

    public void deleteReview(Long reviewId) throws ReviewException;

    public double calculateAverageRating(List<Review> reviews);
}
