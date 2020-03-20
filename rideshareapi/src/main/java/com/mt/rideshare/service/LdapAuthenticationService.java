package com.mt.rideshare.service;

import io.swagger.rideshare.model.User;

public interface LdapAuthenticationService {
	public boolean isAutheneticated(User user);
}
