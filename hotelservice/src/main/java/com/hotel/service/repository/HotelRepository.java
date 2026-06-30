package com.hotel.service.repository;

import com.hotel.service.entities.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<Hotel, String> {
}
