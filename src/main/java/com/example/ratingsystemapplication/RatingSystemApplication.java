package com.example.ratingsystemapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ratingsystemapplication.entity.RideRatingInfo;
import com.example.ratingsystemapplication.entity.UserRating;
import com.example.ratingsystemapplication.repository.RideRatingInfoRepository;
import com.example.ratingsystemapplication.repository.UserRatingRepository;

@SpringBootApplication
public class RatingSystemApplication implements CommandLineRunner {

	@Autowired
	private UserRatingRepository userRatingRepository;
	
	@Autowired
	private RideRatingInfoRepository rideRatingInfoRepository;

	public static void main(String[] args) {
		SpringApplication.run(RatingSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserRating userRating1 = userRatingRepository.findByEmail("driver123@gmail.com");
		UserRating userRating2 = userRatingRepository.findByEmail("rider456@gmail.com");
		if (userRating1 == null) {
			userRatingRepository.save(new UserRating("driver123", "driver123@gmail.com", "driver"));
		}
		if(userRating2 == null) {
			userRatingRepository.save(new UserRating("rider456", "rider456@gmail.com", "rider"));
		}
		RideRatingInfo rideRatingInfo = rideRatingInfoRepository.findByRideId("123456");
		if (rideRatingInfo == null) {
			rideRatingInfoRepository.save(new RideRatingInfo("123456", "rider456@gmail.com", "driver123@gmail.com"));
		}		
	}

}
