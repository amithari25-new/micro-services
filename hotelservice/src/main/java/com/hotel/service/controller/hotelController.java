package com.hotel.service.controller;

import com.hotel.service.entities.Hotel;
import com.hotel.service.repository.HotelRepository;
import com.hotel.service.services.HotelService;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class hotelController {
    @Autowired public HotelService hotelService;
    private Logger logger = LoggerFactory.getLogger(HotelService.class);

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel_resp = hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel_resp);
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> allHotels = hotelService.getAllHotels();
        return ResponseEntity.ok(allHotels);
    }
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        logger.info("Request received to fetch the Hotel info for hotelId: {}", hotelId);
        Hotel hotel = hotelService.getHotel(hotelId);
        return ResponseEntity.ok(hotel);
    }
}
