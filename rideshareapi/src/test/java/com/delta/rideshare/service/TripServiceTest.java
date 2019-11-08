package com.delta.rideshare.service;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.util.Asserts;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.mt.rideshare.assembler.TripSummaryAssembler;
import com.mt.rideshare.db.entity.ProviderRideInfo;
import com.mt.rideshare.db.entity.Vehicalinfo;
import com.mt.rideshare.db.repository.TripRepository;
import com.mt.rideshare.service.impl.TripServiceImpl;

import io.swagger.rideshare.model.Trip;
import io.swagger.rideshare.model.User;
import io.swagger.rideshare.model.Vehicle;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceTest {

	@InjectMocks
	TripServiceImpl tripService;

	@Mock
	TripRepository tripRepository;

	@Mock
	TripSummaryAssembler tripSummaryAssembler;
	
	@Mock
	RestTemplate restTemplate;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() {
		tripService = null;
		tripRepository = null;
		tripSummaryAssembler = null;
	}

	@Test
	public void testVehicleSave() {
		List<Trip> listTrip = new ArrayList<>();
		Trip trip = new Trip();
		trip.setAvailbleSeatSpace("5");
		trip.setFromLocation("SMY");
		trip.availbleluggageSpace("2");
		trip.setComments("nice");
		trip.setDropOffLocation("Admin");
		trip.setFromLocation("SMY");
		trip.setId(new Long(10));
		trip.setPickupLocation("Windy Hill");
		trip.setStatus("Open");
		trip.setTime("8:30 AM");
		trip.setToLocation("ATL");
		trip.setTripType("RT");
		User user = new User();
		// user.setId(1);
		trip.setUser(user);
		Vehicle vehicle = new Vehicle();
		vehicle.setId(new Long(1));
		trip.setVehicle(vehicle);

		ProviderRideInfo providerRideInfo = new ProviderRideInfo();
		com.mt.rideshare.db.entity.User userdb = new com.mt.rideshare.db.entity.User();
		userdb.setUserId(user.getUsername());
		providerRideInfo.setProviderId(userdb);
		providerRideInfo.setTripTime(new Date(8));
		Vehicalinfo vehicalinfo = new Vehicalinfo();
		vehicalinfo.setLicensePlate("132123");
		providerRideInfo.setVehicalId(vehicalinfo);
		providerRideInfo.setAvaialbleSeats(5);
		providerRideInfo.setFromLoc("SMY");
		providerRideInfo.setToLoc("ATL");
		providerRideInfo.setAvailaleLuggageSpace(2);
		providerRideInfo.setFromPickupPoint("windy Hill");
		providerRideInfo.setToPickupPoint("Admin");
		providerRideInfo.setTripStatus("Open");
		// providerRideInfo.setUser((User)trip.getUser());
		providerRideInfo.setTripComments("VCBBVVJJHJ");
		providerRideInfo.setTripType("RT");

		Mockito.doReturn(providerRideInfo).when(tripRepository).save(Mockito.any());

		listTrip.add(trip);
		Mockito.doReturn(listTrip).when(tripSummaryAssembler).convertToTripModel(Mockito.any());

		trip = tripService.createTrip(trip);

		assertNotNull(providerRideInfo);

	}
	@Test
	public void testFindAvailbaleTrips(){
		
		List<Trip> listTrip = new ArrayList<>();
		Trip trip = new Trip();
		trip.setAvailbleSeatSpace("5");
		trip.setFromLocation("SMY");
		trip.availbleluggageSpace("2");
		trip.setComments("nice");
		trip.setDropOffLocation("Admin");
		trip.setFromLocation("SMY");
		trip.setId(new Long(10));
		trip.setPickupLocation("Windy Hill");
		trip.setStatus("Open");
		trip.setTime("8:30 AM");
		trip.setToLocation("ATL");
		trip.setTripType("RT");
		User user = new User();
		// user.setId(1);
		trip.setUser(user);
		Vehicle vehicle = new Vehicle();
		vehicle.setId(new Long(1));
		trip.setVehicle(vehicle);
		listTrip.add(trip);
		
		
		ProviderRideInfo providerRideInfo = new ProviderRideInfo();
		com.mt.rideshare.db.entity.User userdb = new com.mt.rideshare.db.entity.User();
		userdb.setUserId(user.getUsername());
		providerRideInfo.setProviderId(userdb);
		providerRideInfo.setTripTime(new Date(8));
		Vehicalinfo vehicalinfo = new Vehicalinfo();
		vehicalinfo.setLicensePlate("132123");
		providerRideInfo.setVehicalId(vehicalinfo);
		providerRideInfo.setAvaialbleSeats(5);
		providerRideInfo.setFromLoc("SMY");
		providerRideInfo.setToLoc("ATL");
		providerRideInfo.setAvailaleLuggageSpace(2);
		providerRideInfo.setFromPickupPoint("windy Hill");
		providerRideInfo.setToPickupPoint("Admin");
		providerRideInfo.setTripStatus("Open");
		// providerRideInfo.setUser((User)trip.getUser());
		providerRideInfo.setTripComments("VCBBVVJJHJ");
		providerRideInfo.setTripType("RT");
		
		
		List<ProviderRideInfo> providerRideInfos = new ArrayList<>();
		providerRideInfos.add(providerRideInfo);

		Mockito.doReturn(providerRideInfos).when(tripRepository).getAvailableTrips(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
		
		Mockito.doReturn(listTrip).when(tripSummaryAssembler).convertToTripModel(Mockito.any());
		
		
		List<Trip> searchTrips = tripService.findAvailbaleTrips("MAR", "GIO", "2019-10-20 12:30");
		assertNotNull(searchTrips);
		

	}
	
	@Test
	public void testCancelTrip(){
		Trip trip = new Trip();
		trip.setAvailbleSeatSpace("5");
		trip.setFromLocation("ATL");
		trip.availbleluggageSpace("2");
		trip.setComments("SUV");
		trip.setDropOffLocation("GO");
		trip.setFromLocation("ATL");
		trip.setId(new Long(10));
		trip.setPickupLocation("PEACHTREE ST");
		trip.setStatus("Open");
		trip.setTime("8:30 AM");
		trip.setToLocation("ATL");
		trip.setTripType("RT");
		User user = new User();
		// user.setId(1);
		trip.setUser(user);
		Vehicle vehicle = new Vehicle();
		vehicle.setId(new Long(1));
		trip.setVehicle(vehicle);

		ProviderRideInfo providerRideInfo = new ProviderRideInfo();
		com.mt.rideshare.db.entity.User userdb = new com.mt.rideshare.db.entity.User();
		userdb.setUserId(user.getUsername());
		providerRideInfo.setProviderId(userdb);
		providerRideInfo.setTripTime(new Date(8));
		Vehicalinfo vehicalinfo = new Vehicalinfo();
		vehicalinfo.setLicensePlate("132123");
		providerRideInfo.setVehicalId(vehicalinfo);
		providerRideInfo.setAvaialbleSeats(5);
		providerRideInfo.setFromLoc("ATL");
		providerRideInfo.setToLoc("GO");
		providerRideInfo.setAvailaleLuggageSpace(2);
		providerRideInfo.setFromPickupPoint("PEACHTREE ST");
		providerRideInfo.setToPickupPoint("GO");
		providerRideInfo.setTripStatus("Open");
		// providerRideInfo.setUser((User)trip.getUser());
		providerRideInfo.setTripComments("VCBBVVJJHJ");
		providerRideInfo.setTripType("RT");

		Mockito.doReturn(providerRideInfo).when(tripRepository).findByTripId(trip.getId().intValue());
		Mockito.doReturn(trip).when(tripSummaryAssembler).convertToTrip(providerRideInfo);
		Trip deletedTrip = tripService.cancelTrip(trip.getId()+"");
		
		assertNotNull(deletedTrip);
	}
}
