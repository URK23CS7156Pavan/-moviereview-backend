package com.example.movies.controller;

import com.example.movies.service.SeatService;
import com.example.movies.model.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies/{movieId}/seats")
@CrossOrigin(origins = "*")
public class SeatController {

    @Autowired
    private SeatService seatService;

    // Get all available seats for a specific movie
    @GetMapping
    public List<Seat> getSeats(@PathVariable Long movieId) {
        return seatService.getSeatsForMovie(movieId);
    }

    // Book selected seats
    @PostMapping("/book")
    public void bookSeats(@PathVariable Long movieId, @RequestBody List<Long> seatIds) {
        seatService.bookSeats(movieId, seatIds);
    }

    // Add new seats for a specific movie (optional feature)
    @PostMapping
    public List<Seat> addSeats(@PathVariable Long movieId, @RequestBody List<String> seatNumbers) {
        return seatService.addSeats(movieId, seatNumbers);
    }
}
