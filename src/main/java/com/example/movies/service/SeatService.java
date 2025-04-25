package com.example.movies.service;

import com.example.movies.model.Movie;
import com.example.movies.model.Seat;
import com.example.movies.repository.MovieRepository;
import com.example.movies.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private MovieRepository movieRepository;

    // Get all available seats for a movie
    public List<Seat> getSeatsForMovie(Long movieId) {
        return seatRepository.findByMovieId(movieId);
    }

    // Book seats for a movie
    public void bookSeats(Long movieId, List<Long> seatIds) {
        List<Seat> seats = seatRepository.findAllById(seatIds);
        for (Seat seat : seats) {
            seat.setAvailable(false); // Mark seat as unavailable
            seatRepository.save(seat);
        }
    }

    // Add seats for a movie (optional feature)
    public List<Seat> addSeats(Long movieId, List<String> seatNumbers) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if (movie != null) {
            for (String seatNumber : seatNumbers) {
                Seat seat = new Seat();
                seat.setSeatNumber(seatNumber);
                seat.setAvailable(true); // Initially available
                seat.setMovie(movie);
                seatRepository.save(seat);
            }
        }
        return seatRepository.findByMovieId(movieId);
    }
}
