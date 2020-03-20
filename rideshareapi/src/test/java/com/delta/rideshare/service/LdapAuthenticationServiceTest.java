package com.delta.rideshare.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.mt.rideshare.service.impl.LdapAuthenticationServiceImpl;

import io.swagger.rideshare.model.User;

@RunWith(MockitoJUnitRunner.class)
public class LdapAuthenticationServiceTest {

	@Mock
	LdapAuthenticationServiceImpl ldapAuthenticationService;
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() {
		ldapAuthenticationService = null;
	}
	@Test
	public void testLdapAuthentication(){
		User outputUser = new User();
		outputUser.setFirstName("Agniv");
		outputUser.setLastName("Dutta");
		outputUser.setUsername("408995");
		Mockito.doReturn(false).when(ldapAuthenticationService).isAutheneticated(Mockito.any());
		
		User input = new User();
		input.setUsername("040899500");
		input.setSecretKey("DEWFEW");
		boolean isAutheticated = ldapAuthenticationService.isAutheneticated(input);
		assertTrue(!isAutheticated);
	}
}
