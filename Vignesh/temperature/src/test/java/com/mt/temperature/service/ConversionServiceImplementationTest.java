package com.mt.temperature.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConversionServiceImplementationTest {
	
	@InjectMocks
	private ConversionServiceImplementation conversionService;
	
	@Test
	public void convertCelsiusToFahrenheit() {
		assertEquals(BigDecimal.valueOf(212.0), conversionService.convertCelsiusToFahrenheit(BigDecimal.valueOf(100)), "Should return fahrenheit value");
	
	}
	
	@Test
	public void converFahrenheitToCelsius() {
		assertEquals(BigDecimal.valueOf(37.77777777777778), conversionService.converFahrenheitToCelsius(BigDecimal.valueOf(100)), "Should return celsius value");
	}
	

}
