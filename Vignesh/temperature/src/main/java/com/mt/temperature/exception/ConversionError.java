package com.mt.temperature.exception;

public class ConversionError {

	public int errorCode;
	public String errorMessage;

	public ConversionError(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
