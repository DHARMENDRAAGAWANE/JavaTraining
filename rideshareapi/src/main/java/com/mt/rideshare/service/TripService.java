package com.mt.rideshare.service;

import java.util.List;

import io.swagger.rideshare.model.Trip;

public interface TripService {

	public Trip createTrip(Trip trip);
	
	public Trip cancelTrip(String  tripId);
	
	public List<Trip> findAvailbaleTrips(String source ,String destination ,String time );
	
	
	
}
