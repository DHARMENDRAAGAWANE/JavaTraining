package com.delta.rideshare.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.mt.rideshare.assembler.UserDataAssembler;
import com.mt.rideshare.db.repository.UserRepository;
import com.mt.rideshare.service.LdapAuthenticationService;
import com.mt.rideshare.service.impl.UserServiceImpl;

import io.swagger.rideshare.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	UserServiceImpl userService;
	@Mock
	LdapAuthenticationService ldapAuthenticationService;
	@Mock
	UserRepository userDataRepository;
	@Mock
	UserDataAssembler userDataAssembler;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() {
		ldapAuthenticationService = null;
		userDataRepository = null;
		userService = null;
		userDataAssembler = null;
	}

	@Test
	public void testAuthenticateUser() {
		User inputUser = new User();
		inputUser.setUsername("040899500");
		inputUser.setSecretKey("GDGDH##SD");

		User outputUser = new User();
		outputUser.setFirstName("Agniv");
		outputUser.setLastName("Dutta");
		outputUser.setEmail("agniv.dutta@delta.com");
		outputUser.setPhone("4044123456");
		outputUser.setUsername("408995");
		
		Mockito.doReturn(true).when(ldapAuthenticationService).isAutheneticated(Mockito.any());
		
		com.mt.rideshare.db.entity.User dbUser = new com.mt.rideshare.db.entity.User();
		dbUser.setEmail("agniv.dutta@delta.com");
		dbUser.setUserId("408995");
		dbUser.setModeOfContact("M");
		dbUser.setPhoneNo("4044221234");
		dbUser.setCreatedBy("408995");
		dbUser.setCreateTime(new Date());
		Mockito.doReturn(dbUser).when(userDataRepository).findByUserId(Mockito.any());

		

		Mockito.doReturn(outputUser).when(userDataAssembler).convertToUserModel(Mockito.any(),Mockito.any());
		
		User authenticatedUser = userService.authenticateUser(inputUser);
		assertNotNull(authenticatedUser);

	}


	
	public void testFindByUserId(){
		com.mt.rideshare.db.entity.User dbUser = new com.mt.rideshare.db.entity.User();
		dbUser.setEmail("agniv.dutta@delta.com");
		dbUser.setUserId("408995");
		dbUser.setModeOfContact("M");
		dbUser.setPhoneNo("4044221234");
		dbUser.setCreatedBy("408995");
		dbUser.setCreateTime(new Date());
		Mockito.doReturn(dbUser).when(userDataRepository).findByUserId(Mockito.any());
		User inputUser = new User();
		userService.insertUser(inputUser);
		
	}

}
