package com.mt.temperature.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@RunWith(JUnitPlatform.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CelsiusControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@InjectMocks
	private CelsiusController celsiusController;
	
	
	@Test
	public void convertFahrenheitToCelsius() throws Exception {
		assertEquals(BigDecimal.valueOf(37.77777777777778), this.restTemplate.getForObject("http://localhost:" + port + "/convertCelsius?fahrenheit=100", BigDecimal.class));
	}

}
