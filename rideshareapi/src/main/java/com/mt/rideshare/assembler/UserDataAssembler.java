package com.mt.rideshare.assembler;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.mt.rideshare.db.entity.User;

@Component
public class UserDataAssembler {
	public User convertToUserEntity(io.swagger.rideshare.model.User inputUser) {
		User user = new User();
		user.setUserId(inputUser.getUsername());
		user.setEmail(inputUser.getEmail());
		user.setModeOfContact(inputUser.getModeOfContact());
		user.setPhoneNo(inputUser.getPhone());
		user.setCreatedBy(inputUser.getUsername());
		user.setCreateTime(new Date());
		return user;
	}

	public io.swagger.rideshare.model.User convertToUserModel(User user,io.swagger.rideshare.model.User inputUser) {
		io.swagger.rideshare.model.User userModel = new io.swagger.rideshare.model.User();
		userModel.setUsername(inputUser.getUsername());
		userModel.setFirstName(inputUser.getFirstName());
		userModel.setLastName(inputUser.getLastName());
		if (user != null) {
			userModel.setEmail(user.getEmail());
			
			userModel.setModeOfContact(user.getModeOfContact());
			userModel.setPhone(user.getPhoneNo());
			userModel.setStatus(user.getUserType());
		}
		return userModel;
	}
}
