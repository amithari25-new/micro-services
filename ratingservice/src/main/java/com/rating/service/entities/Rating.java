package com.rating.service.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("ratings")
public class Rating {
    @Id
    private String id;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
