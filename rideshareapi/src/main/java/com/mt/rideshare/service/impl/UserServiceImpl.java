package com.mt.rideshare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.rideshare.assembler.UserDataAssembler;
import com.mt.rideshare.db.repository.UserRepository;
import com.mt.rideshare.service.LdapAuthenticationService;
import com.mt.rideshare.service.UserService;

import io.swagger.rideshare.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	LdapAuthenticationService ldapAuthenticationService;
	@Autowired
	UserRepository userDataRepository;
	@Autowired
	UserDataAssembler userDataAssembler;
	@Override
	public User authenticateUser(User inputUser) {
		ldapAuthenticationService.isAutheneticated(inputUser);
		com.mt.rideshare.db.entity.User dbUserDetails = userDataRepository.findByUserId(inputUser.getUsername());
		return userDataAssembler.convertToUserModel(dbUserDetails,inputUser);
	}
	public void insertUser(User inputUser){
		com.mt.rideshare.db.entity.User dbUser = userDataAssembler.convertToUserEntity(inputUser);
		userDataRepository.save(dbUser);
	}

}
