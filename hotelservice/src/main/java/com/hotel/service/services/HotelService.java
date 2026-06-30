package com.hotel.service.services;

import com.hotel.service.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    //create hotel
    Hotel create(Hotel hotel);

    //get hotel by id
    Hotel getHotel(String id);

    //get all hotels
    List<Hotel> getAllHotels();

    //get hotels by rating id
}
