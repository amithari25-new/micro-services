package com.hotel.service.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("hotels")
public class Hotel {
    @Id
    private String id;
    private String name;
    private String location;

}
