package com.mt.rideshare.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

public class RideShareException extends BaseRuntimeException{
	private static final long serialVersionUID = 5873793184595004489L;

	public RideShareException(List<io.swagger.rideshare.model.Error> errorCodes, Object baseRequest, HttpStatus httpStatus) {
		super(errorCodes, baseRequest, httpStatus);
	}
}
