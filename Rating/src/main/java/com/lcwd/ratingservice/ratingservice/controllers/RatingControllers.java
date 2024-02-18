package com.lcwd.ratingservice.ratingservice.controllers;

import com.lcwd.ratingservice.ratingservice.entities.Rating;
import com.lcwd.ratingservice.ratingservice.services.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingControllers {
    @Autowired
    private RatingServices ratingServices;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingServices.create(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings()
    {
        return ResponseEntity.status(HttpStatus.OK).body(ratingServices.getRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(ratingServices.getRatingsByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(ratingServices.getRatingsByHotelId(hotelId));
    }
}
