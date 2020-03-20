package com.mt.rideshare.assembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.mt.rideshare.db.entity.ProviderRideInfo;
import com.mt.rideshare.db.entity.User;
import com.mt.rideshare.db.entity.Vehicalinfo;
import com.mt.rideshare.util.CommonUtil;

import io.swagger.rideshare.model.Trip;
import io.swagger.rideshare.model.Vehicle;

@Component
public class TripSummaryAssembler {
	public List<Trip> convertToTripModel(List<ProviderRideInfo> providerRideInfos) {
		List<Trip> trips = new ArrayList<>();
		Optional.ofNullable(providerRideInfos).orElse(Collections.emptyList()).forEach(providerRideInfo -> {
			Trip trip = convertToTrip(providerRideInfo);
			trips.add(trip);
		});
		return trips;
	}

	public Trip convertToTrip(ProviderRideInfo providerRideInfo) {
		Trip trip = new Trip();
		trip.setId(Long.valueOf(providerRideInfo.getId()));
		trip.setFromLocation(providerRideInfo.getFromLoc());
		trip.setToLocation(providerRideInfo.getToLoc());
		trip.setAvailbleSeatSpace(String.valueOf(providerRideInfo.getAvaialbleSeats()));
		trip.setTime(CommonUtil.convertDateToString(providerRideInfo.getTripTime()));
		trip.setComments(providerRideInfo.getTripComments());
		trip.setTripType(providerRideInfo.getTripType());

		// User Setting
		User user = providerRideInfo.getVehicalId().getOwnerid();
		if(user!=null){
		io.swagger.rideshare.model.User userModel = new io.swagger.rideshare.model.User();
		userModel.setEmail(user.getEmail());
		userModel.setUsername(user.getUserId());
		userModel.setModeOfContact(user.getModeOfContact());
		userModel.setPhone(user.getPhoneNo());
		userModel.setUserType(user.getUserType());
		trip.setUser(userModel);

		List<Vehicle> vehicles = new ArrayList<>();
			List<Vehicalinfo> vehicalinfos = user.getVehicalinfoList();
		Optional.ofNullable(vehicalinfos).orElse(Collections.emptyList()).forEach(vehicalinfo -> {
			Vehicle vehicle = new Vehicle();
			
			vehicle.setColor(vehicalinfo.getColor());
			vehicle.setLicensePlateNum(vehicalinfo.getLicensePlate());
			vehicle.setLuggageCapacity(vehicalinfo.getLuggageCapacity());
			vehicle.setPassengerCapacity(vehicalinfo.getPassengerCapacity());
			vehicle.setStatus(vehicalinfo.getStatus());
			vehicle.setType(vehicalinfo.getType());
			vehicles.add(vehicle);
		});
		
		if (!vehicles.isEmpty()) {
			trip.setVehicle(vehicles.get(0));
		}
		}
		return trip;
	}
	
}
