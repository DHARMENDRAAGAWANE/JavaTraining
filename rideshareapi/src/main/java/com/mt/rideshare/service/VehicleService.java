package com.mt.rideshare.service;

import java.util.List;

import com.mt.rideshare.db.entity.Vehicalinfo;

import io.swagger.rideshare.model.Vehicle;

public interface VehicleService {

	Vehicalinfo saveVehicle(Vehicle vehicle);
	
	List<Vehicalinfo> searchVehicles(String ownerId);
}
