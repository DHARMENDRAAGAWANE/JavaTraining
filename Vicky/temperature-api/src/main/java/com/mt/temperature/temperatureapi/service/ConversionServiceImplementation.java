package com.mt.temperature.temperatureapi.service;

import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImplementation implements ConversionService {

	@Override
	public int convertCelsiusToFahrenheit(int celcius) {
		//(T(°C) x 9/5) + 32)
		int convertedCelcius = (celcius * 9/5) +32;
		return convertedCelcius;
	}

	@Override
	public int convertFahrenheitToCelsius(int fahrenheit) {
		//(T(°F) - 32) × 5/9
		int convertedFahrenheit = (fahrenheit - 32) * 5/9;
		return convertedFahrenheit;
	}

}
