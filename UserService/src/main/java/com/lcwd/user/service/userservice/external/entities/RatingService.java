package com.lcwd.user.service.userservice.external.entities;

import com.lcwd.user.service.userservice.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(name ="RATING-SERVICE")
@Service//using for test file
public interface RatingService {

    @GetMapping("/ratings")
    public Rating getRating();

    @GetMapping("/ratings/{id}")
    public Rating getRating(@PathVariable String id);

    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
