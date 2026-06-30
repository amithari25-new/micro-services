package com.user.service.entites;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("users")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private List<Rating> ratings;

}
