package com.hotel.service.services.impl;

import com.hotel.service.entities.Hotel;
import com.hotel.service.exceptions.ResourceNotFoundException;
import com.hotel.service.repository.HotelRepository;
import com.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with hotel id: "+hotelId));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
