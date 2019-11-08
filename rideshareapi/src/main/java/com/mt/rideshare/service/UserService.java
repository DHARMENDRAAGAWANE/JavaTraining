package com.mt.rideshare.service;

import io.swagger.rideshare.model.User;

public interface UserService {
	public User authenticateUser(User inputUser);
	public void insertUser(User inputUser);
}
