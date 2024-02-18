package com.lcwd.hotel.hotelService.Repositories;

import com.lcwd.hotel.hotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
