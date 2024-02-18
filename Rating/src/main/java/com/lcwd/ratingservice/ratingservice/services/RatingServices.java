package com.lcwd.ratingservice.ratingservice.services;

import com.lcwd.ratingservice.ratingservice.entities.Rating;

import java.util.List;

public interface RatingServices {
    Rating create(Rating rating);
    List<Rating> getRatings();
    List<Rating> getRatingsByUserId(String userId);
    List<Rating> getRatingsByHotelId(String hotelId);
}
