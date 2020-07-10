package com.example.ratingsystemapplication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.ratingsystemapplication.entity.UserRating;

public interface UserRatingRepository extends MongoRepository<UserRating, String> {

	UserRating findByEmail(String email);

}
