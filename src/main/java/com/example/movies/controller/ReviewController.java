package com.example.movies.controller;

import com.example.movies.model.Review;
import com.example.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies/{movieId}/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Get all reviews for a movie
    @GetMapping
    public List<Review> getReviews(@PathVariable Long movieId) {
        return reviewService.getReviewsByMovieId(movieId);
    }

    // Add a new review
    @PostMapping
    public Review addReview(@PathVariable Long movieId, @RequestBody Review review) {
        return reviewService.addReview(movieId, review);
    }
}
