package com.lcwd.user.service.userservice;

import com.lcwd.user.service.userservice.entities.Rating;
import com.lcwd.user.service.userservice.external.entities.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    private RatingService ratingService;

    @Test
    void contextLoads() {
    }
    @Test
    void createRating()
    {
        Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("feign testing feedback").build();
        Rating savedRating = ratingService.createRating(rating);
        System.out.println("rating saved");
    }
}
