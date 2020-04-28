package com.mt.dareToTry.controller;





import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.mt.daretotry.dto.UserDTO;
import com.mt.daretotry.entity.User;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SignUpControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testSignUp() throws Exception {
		UserDTO userDto = new UserDTO();
		userDto.setUsername("mani");
		userDto.setPassword("mani");

		assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/api/signup", userDto, User.class)
				.getUsername()).contains("mani");
	}
}
