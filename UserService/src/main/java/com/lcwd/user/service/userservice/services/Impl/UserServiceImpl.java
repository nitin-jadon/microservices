package com.lcwd.user.service.userservice.services.Impl;

import com.lcwd.user.service.userservice.entities.Hotel;
import com.lcwd.user.service.userservice.entities.Rating;
import com.lcwd.user.service.userservice.entities.User;
import com.lcwd.user.service.userservice.exceptions.UserNotFoundException;
import com.lcwd.user.service.userservice.external.entities.HotelService;
import com.lcwd.user.service.userservice.repositories.UserRepository;
import com.lcwd.user.service.userservice.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        String id = UUID.randomUUID().toString();
        user.setUserId(id);
        return userRepository.save(user);
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User is not found with id: " + userId));
        Rating[] userRatings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + userId, Rating[].class);
        log.info("{}", userRatings);
        List<Rating> ratingList = Arrays.stream(userRatings).toList();

        ratingList.stream().map(rating ->{
//           ResponseEntity<Hotel> hotel = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//           rating.setHotel(hotel.getBody());
            //log.info("{}", hotel.getStatusCode());
            //Second way of communicating with another service
            rating.setHotel(hotelService.getHotel(rating.getHotelId()));

           return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }
}
