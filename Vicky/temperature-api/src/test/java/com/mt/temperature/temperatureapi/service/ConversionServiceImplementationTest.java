package com.mt.temperature.temperatureapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConversionServiceImplementationTest {

	@InjectMocks
	private ConversionServiceImplementation conversionService;
	
	@Test
	public void convertCelsiusToFahrenheit() {
		assertEquals(212, conversionService.convertCelsiusToFahrenheit(100), "Should return converted value from celsius to fahrenheit");
	}
	
	@Test
	public void convertFahrenheitToCelsius() {
		assertEquals(37, conversionService.convertFahrenheitToCelsius(100), "Should return converted value from fahrenheit to celsius");
	}

}
