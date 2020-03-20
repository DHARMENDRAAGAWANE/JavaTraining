package com.mt.rideshare.exception;

public enum ErrorCodes {

	LDAPVALIDATION("ERROR1001");
	private String code;

	ErrorCodes(String code) {
		this.code = code;
	}

	public String code() {
		return code;
	}

}
