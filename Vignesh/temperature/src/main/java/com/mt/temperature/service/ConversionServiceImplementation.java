package com.mt.temperature.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.mt.temperature.exception.NumberNotFoundException;

@Service
public class ConversionServiceImplementation implements ConversionService {

	@Override
	public BigDecimal convertCelsiusToFahrenheit(BigDecimal celsius) {
		// TODO Auto-generated method stub
		try {
			double convertCelsiusToFahrenheit = 9 * (celsius.doubleValue()/5) + 32;
			return BigDecimal.valueOf(convertCelsiusToFahrenheit);
		} catch (RuntimeException e) {
			throw new NumberNotFoundException("Celsius Value Not Fount: " + celsius);
		}
	}

	@Override
	public BigDecimal converFahrenheitToCelsius(BigDecimal fahrenheit) {
		// TODO Auto-generated method stub
		try {
			double converFahrenheitToCelsius = (fahrenheit.doubleValue() - 32) * 5 / 9;
			return BigDecimal.valueOf(converFahrenheitToCelsius);
		} catch(RuntimeException e) {
			throw new NumberNotFoundException("Fahrenheit Value Not Fount: " + fahrenheit);
		}
		
	}

}
