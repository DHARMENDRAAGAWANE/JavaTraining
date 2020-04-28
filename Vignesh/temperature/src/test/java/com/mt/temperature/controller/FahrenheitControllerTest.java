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
class FahrenheitControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@InjectMocks
	private FahrenheitController fahrenheitController;
	
	@Test
	public void convertCelsiusToFahrenheit() throws Exception {
		assertEquals(BigDecimal.valueOf(212.0), this.restTemplate.getForObject("http://localhost:" + port + "/convertFahrenheit?celsius=100", BigDecimal.class));
	}

}
