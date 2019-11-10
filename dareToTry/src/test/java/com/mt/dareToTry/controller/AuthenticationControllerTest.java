package com.mt.dareToTry.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mt.daretotry.dto.LoginDTO;
import com.mt.daretotry.dto.TokenDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuthenticationControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testSignUp() throws Exception {
		LoginDTO userDto = new LoginDTO();
		userDto.setUsername("mani");
		userDto.setPassword("mani");

		assertNotNull(this.restTemplate.postForObject("http://localhost:" + port + "/api/auth", userDto, TokenDTO.class)
				.getToken());
	}
}
