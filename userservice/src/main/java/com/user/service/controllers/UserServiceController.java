package com.user.service.controllers;

import com.user.service.entites.Hotel;
import com.user.service.entites.Rating;
import com.user.service.entites.User;
import com.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserServiceController {
    @Autowired private UserService userService;
    @Autowired private RestTemplate restTemplate;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    public String test() throws Exception {
        return "Served by : " + InetAddress.getLocalHost().getHostName()
                + " Port : " + port;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        logger.info("Request receive to fetch all the user details");
        List<User> allUser = userService.getAllUsers();
        List<User> userList = allUser.stream().peek(user -> {
            String ratingUrl = "http://RATING-SERVICE/ratings/user/"+user.getId();
            Rating[] userRatings = restTemplate.getForObject(ratingUrl, Rating[].class);
            if(Objects.nonNull(userRatings)){
                List<Rating> ratings = Arrays.stream(userRatings).toList();
                List<Rating> ratingList = ratings.stream().peek(rating -> {
                    String hotelUrl = "http://HOTEL-SERVICE/hotels/"+rating.getHotelId();
                    ResponseEntity<Hotel> hotelResp = restTemplate.getForEntity(hotelUrl, Hotel.class);
                    Hotel hotel = hotelResp.getBody();
                    rating.setHotel(hotel);
                }).toList();
            } else {
                List<Rating> EmptyUserRatings = new ArrayList<>();
                user.setRatings(EmptyUserRatings);
            }
            assert userRatings != null;
            user.setRatings(Arrays.stream(userRatings).toList());
        }).toList();
        return ResponseEntity.ok(allUser);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        logger.info("Request received to fetch the user details for userId: {}",userId);
        User user = userService.getUser(userId);
        String url = "http://RATING-SERVICE/ratings/user/" + userId;
        Rating[] userRatings = restTemplate.getForObject(url, Rating[].class);
        assert userRatings != null;
        List<Rating> ratings = Arrays.stream(userRatings).toList();
        List<Rating> ratingList = ratings.stream().peek(rating ->{
            ResponseEntity<Hotel> hotel_resp = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotel_resp.getBody();
            rating.setHotel(hotel);
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/home")
    public String home(){
        return "hello from user service !";
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
