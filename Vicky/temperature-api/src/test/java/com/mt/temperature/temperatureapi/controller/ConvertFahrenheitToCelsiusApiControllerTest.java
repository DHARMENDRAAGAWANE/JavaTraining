package com.mt.temperature.temperatureapi.controller;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ConvertFahrenheitToCelsiusApiControllerTest {

	@Test
	public void contextLoads() {
	}
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void convertFahrenheitToCelsiusShouldReturnInteger() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/convertFahrenheitToCelsius?fahrenheit=",
				Integer.class));
	}

}
