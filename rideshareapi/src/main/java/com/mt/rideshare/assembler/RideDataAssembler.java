package com.mt.rideshare.assembler;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.mt.rideshare.db.entity.ProviderRideInfo;
import com.mt.rideshare.db.entity.RideInfo;
import com.mt.rideshare.db.entity.RideInfoPK;

import io.swagger.rideshare.model.RideDetails;
import io.swagger.rideshare.model.Trip;
import io.swagger.rideshare.model.User;

@Component
public class RideDataAssembler {
	public RideInfo populateRideInfo(String tripId, String userId){
		RideInfo rideInfo = new RideInfo();
		RideInfoPK rideInfoPK = new RideInfoPK();
		rideInfoPK.setConsumerId(userId);
		if(StringUtils.isNotBlank(tripId)){
			rideInfoPK.setProviderRideId(Integer.parseInt(tripId));
		}
		rideInfo.setRideInfoPK(rideInfoPK);
		rideInfo.setStatus("CANCELED");
		rideInfo.setComments("Rider Cancel Trip");
		return rideInfo;
	}
	
	public RideInfo convertToRideInfo(RideDetails rideDetails){
		RideInfo rideInfo = new RideInfo();
		
		Trip trip = (Trip) rideDetails.getTrip();
		User user = (User) rideDetails.getRider();
		
		RideInfoPK rideInfoPK = new RideInfoPK();
		rideInfoPK.setConsumerId(user.getUsername());
		rideInfoPK.setProviderRideId(trip.getId().intValue());
		rideInfo.setRideInfoPK(rideInfoPK);
		
		
		rideInfo.setComments(rideDetails.getComments());
		rideInfo.setStatus("BOOKED");
		
		/*com.delta.rideshare.db.entity.User dbUser = new com.delta.rideshare.db.entity.User();
		dbUser.setCreatedBy(user.getUsername());
		rideInfo.setCreatedBy(dbUser);*/
		
		rideInfo.setCreateTime(new Date());
		return rideInfo;
		
	}
	public void populateSeatCount(ProviderRideInfo providerRideInfo, int count){
	
		providerRideInfo.setAvaialbleSeats(providerRideInfo.getAvaialbleSeats()+count);
	}
}
