package com.mt.rideshare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.rideshare.db.entity.User;
import com.mt.rideshare.db.entity.Vehicalinfo;
import com.mt.rideshare.db.repository.VehicleRepository;
import com.mt.rideshare.service.VehicleService;

import io.swagger.rideshare.model.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;

	@Override
	public Vehicalinfo saveVehicle(Vehicle vehicle) {

		Vehicalinfo vehicleInfo = new Vehicalinfo();
		vehicleInfo.setLicensePlate(vehicle.getLicensePlateNum());
		// TODO Fix this
		User userdb = new User();
		userdb.setUserId(vehicle.getOwner().getUsername());
		vehicleInfo.setOwnerid(userdb);
		vehicleInfo.setColor(vehicle.getColor());
		vehicleInfo.setLuggageCapacity(vehicle.getLuggageCapacity());
		vehicleInfo.setPassengerCapacity(vehicle.getPassengerCapacity());
		vehicleInfo.setStatus(vehicle.getStatus());
		vehicleInfo.setType(vehicle.getType());
		vehicleInfo = vehicleRepository.save(vehicleInfo);
		return vehicleInfo;
	}

	@Override
	public List<Vehicalinfo> searchVehicles(String ownerId) {

		User userdb = new User();
		userdb.setUserId(ownerId);
		List<Vehicalinfo> list = vehicleRepository.findByOwnerid(userdb);

		return list;
	}

}
