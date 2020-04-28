package com.mt.rideshare.service;

import io.swagger.rideshare.model.RideDetails;
import io.swagger.rideshare.model.Trip;

public interface RiderService {

	public RideDetails cancelRiderTrip( String tripId, String userId);
	
	public Trip tripReserve(RideDetails rideDetails);
	
}
