package com.delta.rideshare.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.client.RestTemplate;

import com.mt.rideshare.assembler.RideDataAssembler;
import com.mt.rideshare.assembler.TripSummaryAssembler;
import com.mt.rideshare.db.entity.ProviderRideInfo;
import com.mt.rideshare.db.entity.RideInfo;
import com.mt.rideshare.db.entity.RideInfoPK;
import com.mt.rideshare.db.entity.Vehicalinfo;
import com.mt.rideshare.db.repository.RiderRepository;
import com.mt.rideshare.db.repository.TripRepository;
import com.mt.rideshare.service.impl.RiderServiceImpl;

import io.swagger.rideshare.model.RideDetails;
import io.swagger.rideshare.model.Trip;
import io.swagger.rideshare.model.User;
import io.swagger.rideshare.model.Vehicle;

@RunWith(MockitoJUnitRunner.class)
public class RiderServiceTest {
	@InjectMocks
	RiderServiceImpl riderService;
	
	@Mock
	RideDataAssembler rideDataAssembler;
	@Mock
	TripRepository tripRepository;
	@Mock
	TripSummaryAssembler tripSummaryAssembler;
	
	@Mock
	RiderRepository riderRepository;
	@Mock
	RestTemplate restTemplate;
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() {
		riderService = null;
		rideDataAssembler = null;
		tripRepository = null;
		tripSummaryAssembler = null;
	}
	
	@Test
	public void testTripReserve(){
		RideInfo rideInfo = new RideInfo();
		
		RideInfoPK rideInfoPK = new RideInfoPK();
		rideInfoPK.setConsumerId("408995");
		rideInfoPK.setProviderRideId(1);
		rideInfo.setRideInfoPK(rideInfoPK);
		
		
		rideInfo.setComments("Test Comments");
		
		com.mt.rideshare.db.entity.User dbUser = new com.mt.rideshare.db.entity.User();
		dbUser.setCreatedBy("408995");
		rideInfo.setCreatedBy(dbUser);
		
		rideInfo.setCreateTime(new Date());
		
		Mockito.doReturn(rideInfo).when(rideDataAssembler).convertToRideInfo(Mockito.any());
		Mockito.doReturn(rideInfo).when(riderRepository).save(Mockito.any());
		
		ProviderRideInfo providerRideInfo = new ProviderRideInfo();
		providerRideInfo.setId(1);
		com.mt.rideshare.db.entity.User userdb = new com.mt.rideshare.db.entity.User();
		userdb.setUserId("408995");
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
		//Mockito.doReturn(providerRideInfo).when(tripRepository).findByTripId(Mockito.any());
		Mockito.doNothing().when(rideDataAssembler).populateSeatCount(Mockito.any(),Mockito.anyInt());
		Mockito.doReturn(providerRideInfo).when(tripRepository).save(Mockito.any());
		//Mockito.doReturn(providerRideInfo).when(tripRepository).findByTripId(Mockito.any());
		
		
		List<Trip> listTrip = new ArrayList<>();
		Trip trip = new Trip();
		trip.setId(Long.parseLong("1"));
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
		
		Mockito.doReturn(listTrip).when(tripSummaryAssembler).convertToTripModel(Mockito.any());
		
		RideDetails rideDetails = new RideDetails();
		rideDetails.setId("1");
		User riderUser = new User();
		riderUser.setEmail("agniv.dutta@delta.com");
		rideDetails.setRider(riderUser);
		
		rideDetails.setTrip(trip);
		
		Trip resevedTrip = riderService.tripReserve(rideDetails);
		assertNotNull(resevedTrip);

		
	}
}
