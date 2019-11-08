package com.mt.rideshare.resource;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mt.rideshare.service.RiderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.rideshare.api.RiderApi;
import io.swagger.rideshare.model.Error;
import io.swagger.rideshare.model.RideDetails;
import io.swagger.rideshare.model.Trip;

@Controller
@Api(value = "rider", description = "the rider API")
public class RiderApiController implements RiderApi {
	
	@Autowired
	RiderService riderService;
	
	@ApiOperation(value = "", notes = "This resource used to cancel thier individual trip by a rider", response = RideDetails.class, authorizations = {
	        @Authorization(value = "OauthSecurity", scopes = {
	            
	            })
	    }, tags={ "Rider", })
	    @ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "OK", response = RideDetails.class),
	        @ApiResponse(code = 400, message = "Bad Request.", response = Error.class),
	        @ApiResponse(code = 401, message = "Unauthorized.", response = Error.class),
	        @ApiResponse(code = 403, message = "Forbidden.", response = Error.class),
	        @ApiResponse(code = 404, message = "Not Found.", response = Error.class),
	        @ApiResponse(code = 429, message = "Too Many Requests", response = Error.class),
	        @ApiResponse(code = 500, message = "Internal Server Error.", response = Error.class),
	        @ApiResponse(code = 502, message = "Bad Gateway", response = Error.class),
	        @ApiResponse(code = 503, message = "Service Unavailable", response = Error.class),
	        @ApiResponse(code = 504, message = "Gateway Timeout", response = Error.class) })
	    
	    @RequestMapping(value = "/rider/cancel/{tripId}/user/{userId}",
	        produces = { "application/json" }, 
	        consumes = { "application/json" },
	        method = RequestMethod.POST)
	    public ResponseEntity<RideDetails> cancelRiderTrip(@ApiParam(value = "unique id of the order",required=true ) @PathVariable("tripId") String tripId,@ApiParam(value = "unique id of the order",required=true ) @PathVariable("userId") String userId,@ApiParam(value = "A unique id for each request generated by each application" ) @RequestHeader(value="transactionId", required=false) String transactionId,@ApiParam(value = "The Id of the application within the channel making the request" ) @RequestHeader(value="appId", required=false) String appId,@ApiParam(value = "The Id of the channel making the request" ) @RequestHeader(value="channelId", required=false) String channelId) {
			riderService.cancelRiderTrip(tripId, userId);
	        return new ResponseEntity<RideDetails>(HttpStatus.OK);
	    }


	    @ApiOperation(value = "", notes = "This resource used to reserve a ride on a particular trip", response = Trip.class, authorizations = {
	        @Authorization(value = "OauthSecurity", scopes = {
	            
	            })
	    }, tags={ "Rider", })
	    @ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "OK", response = Trip.class),
	        @ApiResponse(code = 400, message = "Bad Request.", response = Error.class),
	        @ApiResponse(code = 401, message = "Unauthorized.", response = Error.class),
	        @ApiResponse(code = 403, message = "Forbidden.", response = Error.class),
	        @ApiResponse(code = 404, message = "Not Found.", response = Error.class),
	        @ApiResponse(code = 429, message = "Too Many Requests", response = Error.class),
	        @ApiResponse(code = 500, message = "Internal Server Error.", response = Error.class),
	        @ApiResponse(code = 502, message = "Bad Gateway", response = Error.class),
	        @ApiResponse(code = 503, message = "Service Unavailable", response = Error.class),
	        @ApiResponse(code = 504, message = "Gateway Timeout", response = Error.class) })
	    
	    @RequestMapping(value = "/rider/reserve",
	        produces = { "application/json" }, 
	        consumes = { "application/json" },
	        method = RequestMethod.POST)
	    public ResponseEntity<Trip> tripReserve(@ApiParam(value = "Rider Details API Request Object" ,required=true )  @Valid @RequestBody RideDetails rider,@ApiParam(value = "A unique id for each request generated by each application" ) @RequestHeader(value="transactionId", required=false) String transactionId,@ApiParam(value = "The Id of the application within the channel making the request" ) @RequestHeader(value="appId", required=false) String appId,@ApiParam(value = "The Id of the channel making the request" ) @RequestHeader(value="channelId", required=false) String channelId) {
	    	Trip trip = riderService.tripReserve(rider);
	        return new ResponseEntity<Trip>(trip , HttpStatus.OK);
	    }

}
