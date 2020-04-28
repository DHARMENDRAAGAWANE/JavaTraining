package com.mt.temperature.service;

import java.math.BigDecimal;

public interface ConversionService {
	
	public BigDecimal convertCelsiusToFahrenheit(BigDecimal celsius);
	public BigDecimal converFahrenheitToCelsius(BigDecimal fahrenheit);
	
}
