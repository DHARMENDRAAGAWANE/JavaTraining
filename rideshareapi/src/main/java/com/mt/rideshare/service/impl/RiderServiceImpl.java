package com.mt.rideshare.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.mt.rideshare.assembler.RideDataAssembler;
import com.mt.rideshare.assembler.TripSummaryAssembler;
import com.mt.rideshare.db.entity.ProviderRideInfo;
import com.mt.rideshare.db.entity.RideInfo;
import com.mt.rideshare.db.repository.RiderRepository;
import com.mt.rideshare.db.repository.TripRepository;
import com.mt.rideshare.db.repository.UserRepository;
import com.mt.rideshare.service.RiderService;

import io.swagger.rideshare.model.RideDetails;
import io.swagger.rideshare.model.Trip;
import io.swagger.rideshare.model.User;
import io.swagger.rideshare.model.Vehicle;

@Service
public class RiderServiceImpl implements RiderService {

	@Autowired
	RideDataAssembler rideDataAssembler;
	@Autowired
	RiderRepository riderRepository;
	@Autowired
	TripRepository tripRepository;
	@Autowired
	TripSummaryAssembler tripSummaryAssembler;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	@Value("${email.notification.url}")
	private String emailNotificationURL;
	@Value("${email.notification.from}")
	private String emailNotificationFrom;
	
	@Value("${email.notification.rider.booking.confirm.subject}")
	private String emailNotificationRiderBookingConfirmSubject;
	@Value("${email.notification.rider.booking.confirm.body}")
	private String emailNotificationRiderBookingConfirmBody;
	
	@Value("${email.notification.driver.booking.confirm.subject}")
	private String emailNotificationDriverBookingConfirmSubject;
	@Value("${email.notification.driver.booking.confirm.body}")
	private String emailNotificationDriverBookingConfirmBody;
	
	
	
	@Value("${email.notification.rider.cancel.confirm.subject}")
	private String emailNotificationRiderCancelConfirmSubject;
	@Value("${email.notification.rider.cancel.confirm.body}")
	private String emailNotificationRiderCancelConfirmBody;
	
	@Override
	public RideDetails cancelRiderTrip(String tripId, String userId) {
		
		RideInfo rideInfo = rideDataAssembler.populateRideInfo(tripId, userId);
		riderRepository.save(rideInfo);
		
		ProviderRideInfo providerRideInfo = tripRepository.findByTripId(Integer.parseInt(tripId));
		rideDataAssembler.populateSeatCount(providerRideInfo,1);
		tripRepository.save(providerRideInfo);
		
		String emailId = userRepository.findByEmail(userId);
		String phoneNumber = userRepository.findByPhoneNo(userId);
		StringBuilder contenatedIds = new StringBuilder();
		contenatedIds.append(emailId).append(",");
		contenatedIds.append(phoneNumber).append("@txt.att.net,");
		contenatedIds.append(phoneNumber).append("@tmomail.net,");
		contenatedIds.append(phoneNumber).append("@vtext.com");
		
		//Send Email Notification
		sendEmailCancelNotification(contenatedIds.toString());
		
		RideDetails rideDetails = new RideDetails();
		rideDetails.setId(tripId);
		rideDetails.setComments("CANCELED");
		rideDetails.setComments("Ride Trip Canceled");
		return rideDetails;
	}

	@Override
	public Trip tripReserve(RideDetails rideDetails) {
		// Save Rider
		// In future the whole method will be under transaction
		RideInfo rideInfo = rideDataAssembler.convertToRideInfo(rideDetails);
		riderRepository.save(rideInfo);
		
		Trip trip = (Trip) rideDetails.getTrip();
		
		ProviderRideInfo providerRideInfo = tripRepository.findByTripId(trip.getId().intValue());
		
		// In future Calculation need to check first availabity 
		//Reduce the count
		rideDataAssembler.populateSeatCount(providerRideInfo,-1);
		tripRepository.save(providerRideInfo);
		
		//Send Rider Notification
	
		sendRiderConfirmation(rideDetails, trip);
		
		//Send Driver Notification
		sendDriverConfirmation(rideDetails, trip);
		
		// It may not be required
		
		providerRideInfo = tripRepository.findByTripId(trip.getId().intValue());
		List<ProviderRideInfo> providerRideInfos = new ArrayList<>();
		if(providerRideInfo!=null){
			providerRideInfos.add(providerRideInfo);
		}
		List<Trip> trips = tripSummaryAssembler.convertToTripModel(providerRideInfos);
		if(trips!=null && !trips.isEmpty()){
			return trips.get(0);
		}
		return null;
	}

	private void sendRiderConfirmation(RideDetails rideDetails, Trip trip) {
		User user = (User) rideDetails.getRider();
		
		StringBuilder riderContenatedIds = new StringBuilder();
		riderContenatedIds.append(user.getEmail()).append(",");
		riderContenatedIds.append(user.getPhone()).append("@txt.att.net,");
		riderContenatedIds.append(user.getPhone()).append("@tmomail.net,");
		riderContenatedIds.append(user.getPhone()).append("@vtext.com");
		
		String riderBookingBody = emailNotificationRiderBookingConfirmBody;
		User driverUser = trip.getUser();
		StringBuilder nameBuilder = new StringBuilder();
		nameBuilder.append(driverUser.getFirstName()).append(" ").append(driverUser.getLastName());
		riderBookingBody = StringUtils.replace(riderBookingBody, "<name>", nameBuilder.toString());
		riderBookingBody = StringUtils.replace(riderBookingBody, "<ID>", driverUser.getUsername());
		
		if(rideDetails.getTrip()!=null){
			Vehicle vehicle = rideDetails.getTrip().getVehicle();
			if(vehicle!=null){
				riderBookingBody = StringUtils.replace(riderBookingBody, "<License>", vehicle.getLicensePlateNum());
			}
		}
		
		sendEmailConfirmNotification(riderContenatedIds.toString(),riderBookingBody);
	}
	
	private void sendDriverConfirmation(RideDetails rideDetails, Trip trip) {
		User driverUser = trip.getUser();
		
		StringBuilder driverContenatedIds = new StringBuilder();
		driverContenatedIds.append(driverUser.getEmail()).append(",");
		driverContenatedIds.append(driverUser.getPhone()).append("@txt.att.net,");
		driverContenatedIds.append(driverUser.getPhone()).append("@tmomail.net,");
		driverContenatedIds.append(driverUser.getPhone()).append("@vtext.com");
		
		String driverBookingBody = emailNotificationDriverBookingConfirmBody;
		User rideruser = rideDetails.getRider();
		StringBuilder nameBuilder = new StringBuilder();
		nameBuilder.append(rideruser.getFirstName()).append(" ").append(rideruser.getLastName());
		driverBookingBody = StringUtils.replace(driverBookingBody, "<name>", nameBuilder.toString());
		driverBookingBody = StringUtils.replace(driverBookingBody, "<ID>", rideruser.getUsername());
		
		
		
		sendEmailConfirmNotification(driverContenatedIds.toString(),driverBookingBody);
	}
	
	private void sendEmailCancelNotification(String concatednatedIds) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		httpHeaders.add("from", emailNotificationFrom);
		httpHeaders.add("to", concatednatedIds);
		httpHeaders.add("subject", emailNotificationRiderCancelConfirmSubject);
		httpHeaders.add("body", emailNotificationRiderCancelConfirmBody);
		HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
		try {
			restTemplate.postForObject(emailNotificationURL, entity, String.class);
		} catch (HttpServerErrorException | HttpClientErrorException exception) {
			// Handle it in future
			exception.printStackTrace();
		}
	}

	private void sendEmailConfirmNotification(String concatednatedIds,String body) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		httpHeaders.add("from", emailNotificationFrom);
		httpHeaders.add("to", concatednatedIds);
		httpHeaders.add("subject", emailNotificationRiderBookingConfirmSubject);
		httpHeaders.add("body", body);
		HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
		try {
			restTemplate.postForObject(emailNotificationURL, entity, String.class);
		} catch (HttpServerErrorException | HttpClientErrorException exception) {
			exception.printStackTrace();
		}
	}

	

}
