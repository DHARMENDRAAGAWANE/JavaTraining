package com.mt.rideshare.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import com.mt.rideshare.db.entity.Vehicalinfo;
import com.mt.rideshare.db.repository.TripRepository;
import com.mt.rideshare.service.TripService;
import com.mt.rideshare.util.CommonUtil;

import io.swagger.rideshare.model.Trip;
import io.swagger.rideshare.model.User;
import io.swagger.rideshare.model.Vehicle;

@Service
public class TripServiceImpl implements TripService {

	@Autowired
	TripRepository tripRepository;
	@Autowired
	TripSummaryAssembler tripSummaryAssembler;

	@Autowired
	RideDataAssembler rideDataAssembler;
	
	@Value("${email.notification.url}")
	private String emailNotificationURL;
	@Value("${email.notification.from}")
	private String emailNotificationFrom;
	
	@Value("${email.notification.driver.trip.confirm.subject}")
	private String emailNotificationDriverTripConfirmSubject;
	@Value("${email.notification.driver.trip.confirm.body}")
	private String emailNotificationDriverTripConfirmBody;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Trip createTrip(Trip trip) {

		ProviderRideInfo providerRideInfo = new ProviderRideInfo();

		User user = (User) trip.getUser();
		com.mt.rideshare.db.entity.User userdb = new com.mt.rideshare.db.entity.User();

		userdb.setUserId(user.getUsername());

		providerRideInfo.setProviderId(userdb);
		providerRideInfo.setTripTime(CommonUtil.convertStringToDate(trip.getTime()));
		if (null != trip.getVehicle()) {
			Vehicalinfo vehicalinfo = new Vehicalinfo();
			vehicalinfo.setLicensePlate(((Vehicle) trip.getVehicle()).getLicensePlateNum());
			providerRideInfo.setVehicalId(vehicalinfo);
		}
		if(StringUtils.isNotBlank(trip.getAvailbleSeatSpace())){
			providerRideInfo.setAvaialbleSeats(Integer.parseInt(trip.getAvailbleSeatSpace()));
		}
		providerRideInfo.setFromLoc(trip.getFromLocation());
		providerRideInfo.setToLoc(trip.getToLocation());
		if(StringUtils.isNotBlank(trip.getAvailbleluggageSpace())){
			providerRideInfo.setAvailaleLuggageSpace(Integer.parseInt(trip.getAvailbleluggageSpace()));
		}
		providerRideInfo.setFromPickupPoint(trip.getPickupLocation());
		providerRideInfo.setToPickupPoint(trip.getDropOffLocation());
		providerRideInfo.setTripStatus(trip.getStatus());
		// providerRideInfo.setUser((User)trip.getUser());
		providerRideInfo.setTripComments(trip.getComments());
		providerRideInfo.setTripType(trip.getTripType());

		providerRideInfo = tripRepository.save(providerRideInfo);
		
		// Send Driver Notification
		String emailId = user.getEmail();
		String phoneNumber = user.getPhone();
		StringBuilder contenatedIds = new StringBuilder();
		contenatedIds.append(emailId).append(",");
		contenatedIds.append(phoneNumber).append("@txt.att.net,");
		contenatedIds.append(phoneNumber).append("@tmomail.net,");
		contenatedIds.append(phoneNumber).append("@vtext.com");
		sendEmailConfirmNotification(contenatedIds.toString());
		
		// this code will resuse agniv assembler method.
		List<ProviderRideInfo> providerRideInfos = new ArrayList<ProviderRideInfo>();
		providerRideInfos.add(providerRideInfo);
		
		

		List<Trip> trips = tripSummaryAssembler.convertToTripModel(providerRideInfos);
		if (!trips.isEmpty()) {
			return trips.get(0);
		}

		return null;
	}

	@Override
	public Trip cancelTrip(String tripId) {
		ProviderRideInfo providerRideInfo = tripRepository.findByTripId(Integer.parseInt(tripId));
		if(providerRideInfo!=null){
			providerRideInfo.setAvaialbleSeats(0);
			providerRideInfo.setAvailaleLuggageSpace(0);
			providerRideInfo.setTripStatus("CANCEL");
			providerRideInfo.setTripComments("DRIVER CANCELED");
			tripRepository.save(providerRideInfo);
			//Need to notify all riders?!
			return tripSummaryAssembler.convertToTrip(providerRideInfo);
		}
		return null;
		
	}

	@Override
	public List<Trip> findAvailbaleTrips(String source, String destination, String dateTime) {
		Date requestedDate = CommonUtil.convertStringToDate(dateTime);
		Date searchStartTime = CommonUtil.getAdjustedDateByMinute(requestedDate, -15);
		Date searchEndTime = CommonUtil.getAdjustedDateByMinute(requestedDate, 15);
		List<ProviderRideInfo> providerRideInfos = tripRepository.getAvailableTrips(source, destination,
				searchStartTime, searchEndTime);
		return tripSummaryAssembler.convertToTripModel(providerRideInfos);
	}
	
	private void sendEmailConfirmNotification(String concatednatedIds) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		httpHeaders.add("from", emailNotificationFrom);
		httpHeaders.add("to", concatednatedIds);
		httpHeaders.add("subject", emailNotificationDriverTripConfirmSubject);
		httpHeaders.add("body", emailNotificationDriverTripConfirmBody);
		HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
		try {
			restTemplate.postForObject(emailNotificationURL, entity, String.class);
		} catch (HttpServerErrorException | HttpClientErrorException exception) {
			exception.printStackTrace();
		}
	}

}
