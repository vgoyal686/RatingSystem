package com.example.ratingsystemapplication.dto;

public class RideRateInfoDto {

	private String rideId;

	private String riderEmail;

	private String driverEmail;

	private Integer ratingByUser;

	private String userRole;

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

	public Integer getRatingByUser() {
		return ratingByUser;
	}

	public void setRatingByUser(Integer ratingByUser) {
		this.ratingByUser = ratingByUser;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
