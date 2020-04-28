package com.mt.daretotry.entity.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mt.daretotry.entity.User;
import com.mt.daretotry.service.UserService;

@Service
public class BasicUserDetailsService implements UserDetailsService {

	private final UserService userService;

	@Autowired
	public BasicUserDetailsService(final UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final User user = userService.findByUsername(username);
		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("User with username:" + username + " not found");
		}
	}
}
