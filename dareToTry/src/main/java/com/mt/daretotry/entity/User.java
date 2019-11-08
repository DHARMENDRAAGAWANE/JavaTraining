package com.mt.daretotry.entity;

import org.springframework.data.annotation.Id;

public class User {
	
	@Id
	String id;
	String firstName;
	String lastName;
	UserType userType;
	public User(String firstName, String lastName, UserType userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userType=" + userType + "]";
	}	

	
	
}
