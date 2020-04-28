package com.mt.temperature.temperatureapi.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mt.temperature.temperatureapi.service.ConversionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.unmaze.temperature.api.ConvertFahrenheitToCelsiusApi;

@RestController
public class ConvertFahrenheitToCelsiusApiController implements ConvertFahrenheitToCelsiusApi {
	
	@Autowired						
	private ConversionService conversionService;
	
	@ApiOperation(value = "Convert fahrenheit to celsius", notes = "Convert fahrenheit to celsius", response = Integer.class, tags={ "conversion", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Integer.class),
        @ApiResponse(code = 400, message = "Invalid status value", response = Void.class) })
    
    @RequestMapping(value = "/convertFahrenheitToCelsius",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public ResponseEntity<Integer> convertFahrenheit( @NotNull@ApiParam(value = "Fahrenheit Value.", required = true, defaultValue = "100") @RequestParam(value = "fahrenheit", required = true, defaultValue="100") Integer fahrenheit) {
		int  celsiusValue = conversionService.convertFahrenheitToCelsius(fahrenheit);
        if(fahrenheit != null) {
        	return new ResponseEntity<Integer>(celsiusValue,HttpStatus.OK);
        } else {
        	return new ResponseEntity<Integer>(0,HttpStatus.BAD_REQUEST);
        }
    }

}
