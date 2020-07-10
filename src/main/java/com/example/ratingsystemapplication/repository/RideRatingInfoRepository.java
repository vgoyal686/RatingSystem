package com.example.ratingsystemapplication.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.ratingsystemapplication.entity.RideRatingInfo;

public interface RideRatingInfoRepository extends MongoRepository<RideRatingInfo, String> {

	RideRatingInfo findByRiderEmail(String riderEmail);

	RideRatingInfo findByDriverEmail(String driverEmail);
	
	RideRatingInfo findByRideId(String rideId);

}
