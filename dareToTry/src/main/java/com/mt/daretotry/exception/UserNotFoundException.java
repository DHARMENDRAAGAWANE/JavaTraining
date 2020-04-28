package com.mt.daretotry.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(final String message) {
		super(message);
	}

	public UserNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}
}