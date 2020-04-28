package com.delta.rideshare.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.mt.rideshare.db.entity.Vehicalinfo;
import com.mt.rideshare.db.repository.VehicleRepository;
import com.mt.rideshare.service.impl.VehicleServiceImpl;

import io.swagger.rideshare.model.User;
import io.swagger.rideshare.model.Vehicle;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceTest {

	@InjectMocks
	VehicleServiceImpl vehicleService;
	
	@Mock
	VehicleRepository vehicleRepository;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@After
	public void tearDown() {
		vehicleService = null;
		vehicleRepository = null;
	}
	
	@Test
	public void testVehicleSave() {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setId(new Long(1));
		vehicle.setColor("Blue");
		vehicle.setLicensePlateNum("HACK-123");
		vehicle.setLuggageCapacity(5);
		vehicle.setPassengerCapacity(5);
		
		User vehicleOwner = new User();
		vehicleOwner.setUsername("408995");
		vehicle.setOwner(vehicleOwner);
		
		Vehicalinfo vehicleInfo = new Vehicalinfo();
		
		Mockito.doReturn(vehicleInfo)
		   .when(vehicleRepository)
		   .save(Mockito.any());

		Vehicalinfo vehicleInfoSaved =  vehicleService.saveVehicle(vehicle);
		
		assertNotNull(vehicleInfoSaved);
		
	}
	
	@Test
	public void testVehicleSearch() {
		
		List<Vehicalinfo> vehicleInfoList = new ArrayList<Vehicalinfo>();
		Vehicalinfo vehicleInfo = new Vehicalinfo();
		vehicleInfoList.add(vehicleInfo);
		
		Mockito.doReturn(vehicleInfoList)
		   .when(vehicleRepository)
		   .findByOwnerid(Mockito.any());
		
		List<Vehicalinfo> vehicleInfoListReturned = vehicleService.searchVehicles("OWNER1");
		
		assertNotNull(vehicleInfoListReturned);
		
	}
}
