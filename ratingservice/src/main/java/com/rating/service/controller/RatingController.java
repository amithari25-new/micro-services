package com.rating.service.controller;

import com.rating.service.entities.Rating;
import com.rating.service.services.RatingService;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired private RatingService ratingService;
    private final Logger logger = LoggerFactory.getLogger(RatingService.class);
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating rating_resp = ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating_resp);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> all_ratings = ratingService.getAllRatings();
        return ResponseEntity.ok(all_ratings);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        logger.info("Request received to fetch the ratings of userId: {}", userId);
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

}
