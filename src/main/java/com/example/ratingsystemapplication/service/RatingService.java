package com.example.ratingsystemapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ratingsystemapplication.dto.Response;
import com.example.ratingsystemapplication.dto.RideRateInfoDto;
import com.example.ratingsystemapplication.dto.RideRatingInfoResponse;
import com.example.ratingsystemapplication.dto.UserRatingResponse;
import com.example.ratingsystemapplication.entity.RideRatingInfo;
import com.example.ratingsystemapplication.entity.UserRating;
import com.example.ratingsystemapplication.repository.RideRatingInfoRepository;
import com.example.ratingsystemapplication.repository.UserRatingRepository;

@Service
public class RatingService {

	@Autowired
	UserRatingRepository userRatingRepository;

	@Autowired
	RideRatingInfoRepository rideRatingInfoRepository;
	
	private static final int MAX_RATING = 5;

	public Response getRating(String email) {
		Response response = new Response();
		UserRating userRating = userRatingRepository.findByEmail(email);
		if (userRating != null) {
			UserRatingResponse userRatingResponse = userRatingMapper(userRating);
			response.setData(userRatingResponse);
		}
		else {
			response.setMessage("User is not found");
		}
		return response;
	}

	public Response giveRating(RideRateInfoDto rideRateInfoDto) {
		Response response = new Response();
		if (rideRateInfoDto.getDriverEmail() != null && rideRateInfoDto.getRiderEmail() != null && rideRateInfoDto.getRideId() != null) {
			UserRating driverRating = userRatingRepository.findByEmail(rideRateInfoDto.getDriverEmail());
			UserRating riderRating = userRatingRepository.findByEmail(rideRateInfoDto.getRiderEmail());
			if (driverRating == null || riderRating == null) {
				response.setMessage("Driver or rider not found");
				return response;
			}
			else {
				RideRatingInfo rideRatingInfo = rideRatingInfoRepository.findByRideId(rideRateInfoDto.getRideId());
				
				if (rideRateInfoDto.getRatingByUser() == null || !validateRating(rideRateInfoDto.getRatingByUser())) {
					response.setMessage("rating is invalid");
				}
				
				if (rideRateInfoDto.getUserRole() == null || rideRateInfoDto.getUserRole().isEmpty() || !rideRateInfoDto.getUserRole().equals("rider") || !rideRateInfoDto.getUserRole().equals("driver")) {
					response.setMessage("userRole is inavlid or empty, it should be driver or rider");
				}
				
				if (rideRatingInfo != null) {
					if (rideRatingInfo.getRatingByDriver() != null && rideRatingInfo.getRatingByRider() != null) {
						response.setMessage("Both driver and rider rated");
						return response;
					}
				}		
				else {
					rideRatingInfo = new RideRatingInfo();
					rideRatingInfo.setDriverEmail(rideRateInfoDto.getDriverEmail());
					rideRatingInfo.setRiderEmail(rideRateInfoDto.getRiderEmail());
					rideRatingInfo.setRideId(rideRateInfoDto.getRideId());
				}
				
				UserRating userRating = new UserRating();
				if (rideRateInfoDto.getUserRole().equals("rider")) {
					userRating = driverRating;
					rideRatingInfo.setRatingByRider(rideRateInfoDto.getRatingByUser());
				} 
				else if (rideRateInfoDto.getUserRole().equals("driver")) {
					userRating = riderRating;
					rideRatingInfo.setRatingByDriver(rideRateInfoDto.getRatingByUser());
				}
				userRating.setTotalUserRated(userRating.getTotalUserRated() + 1);
				userRating.setSumOfMaxRatingUserCount(userRating.getSumOfMaxRatingUserCount() + MAX_RATING);
				userRating.setSumOfRatings(userRating.getSumOfRatings() + rideRateInfoDto.getRatingByUser());
				Float AggRating = calculateAggRating(userRating);
				userRating.setAggRating(AggRating);
				userRatingRepository.save(userRating);
				rideRatingInfoRepository.save(rideRatingInfo);
				UserRatingResponse userRatingResponse = userRatingMapper(userRating);
				response.setData(userRatingResponse);
				return response;
			}
		}
		else {
			response.setMessage("Driver email or rider email or ride id is not present");
		}
	    return response;	
	}

	public Float calculateAggRating(UserRating userRating) {
		if (userRating.getSumOfRatings() != 0) {
			float aggRating = userRating.getSumOfRatings() / (userRating.getTotalUserRated() * 1.0f);
			return aggRating;
		}
		return null;
	}
	
	public UserRatingResponse userRatingMapper(UserRating userRating) {
		UserRatingResponse userRatingResponse = new UserRatingResponse();
		userRatingResponse.setName(userRating.getName());
		userRatingResponse.setEmail(userRating.getName());
		userRatingResponse.setUserRole(userRating.getUserRole());
		userRatingResponse.setAggRating(userRating.getAggRating());
		return userRatingResponse;
	}

	public RideRatingInfoResponse rideRatingInfoMapper(RideRatingInfo rideRatingInfo) {
		RideRatingInfoResponse rideRatingInfoResponse = new RideRatingInfoResponse();
		rideRatingInfoResponse.setRideId(rideRatingInfo.getRideId());
		rideRatingInfoResponse.setRiderEmail(rideRatingInfo.getRiderEmail());
		rideRatingInfoResponse.setDriverEmail(rideRatingInfo.getDriverEmail());
		rideRatingInfoResponse.setRatingByRider(rideRatingInfo.getRatingByRider());
		rideRatingInfoResponse.setRatingByDriver(rideRatingInfo.getRatingByDriver());
		return rideRatingInfoResponse;
	}
	
	public boolean validateRating(Integer rating) {
		if (rating >=1 && rating <= 5) {
			return true;
		}
		return false;
	}
}
