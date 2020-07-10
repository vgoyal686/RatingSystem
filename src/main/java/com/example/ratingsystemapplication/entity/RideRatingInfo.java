package com.example.ratingsystemapplication.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rideRatingInfo")
public class RideRatingInfo extends Asset {

	private String rideId;

	private String riderEmail;

	private String driverEmail;

	private Integer ratingByDriver;

	private Integer ratingByRider;
	
	public RideRatingInfo() {

	}

	public RideRatingInfo(String rideId, String riderEmail, String driverEmail) {
		super();
		this.rideId = rideId;
		this.riderEmail = riderEmail;
		this.driverEmail = driverEmail;
	}

	public String getRideId() {
		return rideId;
	}

	public void setRideId(String rideId) {
		this.rideId = rideId;
	}

	public String getRiderEmail() {
		return riderEmail;
	}

	public void setRiderEmail(String riderEmail) {
		this.riderEmail = riderEmail;
	}

	public String getDriverEmail() {
		return driverEmail;
	}

	public void setDriverEmail(String driverEmail) {
		this.driverEmail = driverEmail;
	}

	public Integer getRatingByDriver() {
		return ratingByDriver;
	}

	public void setRatingByDriver(Integer ratingByDriver) {
		this.ratingByDriver = ratingByDriver;
	}

	public Integer getRatingByRider() {
		return ratingByRider;
	}

	public void setRatingByRider(Integer ratingByRider) {
		this.ratingByRider = ratingByRider;
	}

}
