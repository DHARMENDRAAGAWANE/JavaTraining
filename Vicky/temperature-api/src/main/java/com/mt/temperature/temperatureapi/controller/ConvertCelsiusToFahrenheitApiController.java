package com.mt.temperature.temperatureapi.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mt.temperature.exception.handler.ErrorModel;
import com.mt.temperature.exception.handler.NotFoundException;
import com.mt.temperature.temperatureapi.service.ConversionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.unmaze.temperature.api.ConvertCelsiusToFahrenheitApi;

@Controller
public class ConvertCelsiusToFahrenheitApiController implements ConvertCelsiusToFahrenheitApi {
	
	@Autowired						
	private ConversionService conversionService;
	
	@ApiOperation(value = "Convert celsius to fahrenheit", notes = "Convert celsius to fahrenheit", response = Integer.class, tags={ "conversion", })
	    @ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "successful operation", response = Integer.class),
	        @ApiResponse(code = 400, message = "Invalid status value", response = Void.class) })
	    
	    @RequestMapping(value = "/convertCelsiusToFahrenheit",
	        produces = { "application/json" }, 
	        method = RequestMethod.GET)
	    public ResponseEntity<Integer> convertCelsius( @NotNull@ApiParam(value = "Celsius Value.", required = true) @RequestParam(value = "celsius", required = true) Integer celsius) {
			if(celsius != null) {
				int  fahrenheitValue = conversionService.convertCelsiusToFahrenheit(celsius);
				return new ResponseEntity<Integer>(fahrenheitValue,HttpStatus.OK);
			} else {
				//throw new NotFoundException("Parameter value not found");
				//ErrorModel errorObj = new ErrorModel(HttpStatus.NOT_FOUND,"Input Parameter is required","Paramert Missing");
				return new ResponseEntity<Integer>(0,HttpStatus.BAD_REQUEST);
			}
	        
	    }
}
