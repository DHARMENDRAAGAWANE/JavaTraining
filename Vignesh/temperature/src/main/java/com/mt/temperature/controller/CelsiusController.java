package com.mt.temperature.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mt.temperature.service.ConversionServiceImplementation;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.temperature.api.ConvertCelsiusApi;

@RestController
public class CelsiusController implements ConvertCelsiusApi {

	@Autowired
	private ConversionServiceImplementation conversionService;
	
	 @ApiOperation(value = "Convert fahrenheit to celsius", notes = "Convert fahrenheit to celsius", response = BigDecimal.class, tags={ "conversion", })
	    @ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "Success", response = BigDecimal.class),
	        @ApiResponse(code = 400, message = "Invalid Status Value", response = Void.class),
	        @ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
	    
	    @RequestMapping(value = "/convertCelsius",
	        produces = { "application/json" }, 
	        method = RequestMethod.GET)
	    public ResponseEntity<BigDecimal> convertFahrenheitToCelsius(@ApiParam(value = "fahrenheit Value") @RequestParam(value = "fahrenheit", required = false) BigDecimal fahrenheit) {
	        // do some magic!
		 	BigDecimal Celsius = conversionService.converFahrenheitToCelsius(fahrenheit);
	        return new ResponseEntity<BigDecimal>(Celsius, HttpStatus.OK);
	    }

}
