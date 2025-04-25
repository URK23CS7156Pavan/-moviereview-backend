package com.example.movies.service;

import com.example.movies.model.Movie;
import com.example.movies.model.Review;
import com.example.movies.repository.MovieRepository;
import com.example.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    // Add a new review
    public Review addReview(Long movieId, Review review) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if (movie != null) {
            review.setMovie(movie);
            return reviewRepository.save(review);
        }
        return null;
    }

    // Get all reviews for a specific movie
    public List<Review> getReviewsByMovieId(Long movieId) {
        return reviewRepository.findByMovieId(movieId);
    }
}
