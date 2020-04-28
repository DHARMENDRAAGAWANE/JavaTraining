package com.mt.rideshare.exception;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

import io.swagger.rideshare.model.Error;


/**
 * {@code BaseRuntimeException} is a generic {@link RuntimeException} that has
 * extra attributes like {@code errorCodes} and the request object. This is
 * especially useful for handling generic exception in the
 * {@link org.springframework.web.bind.annotation.ControllerAdvice} decorated
 * {@link com.delta.GlobalExceptionHandler.api.flights.detail.exceptions.handlers.GlobalExceptionHandler}.
 *
 *
 */
public class BaseRuntimeException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 9005429273232703183L;

	private final transient  List<Error> errors;
	private final transient Object baseRequest;
	private  HttpStatus httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;

	public BaseRuntimeException(List<Error> errors, Object baseRequest) {
		super(errors.toString());
		this.errors = errors;
		this.baseRequest = baseRequest;
		

	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public BaseRuntimeException(List<Error> errors, Object baseRequest, HttpStatus httpStatus) {
		super(errors.toString());
		this.errors = errors;
		this.baseRequest = baseRequest;
		this.httpStatus = httpStatus;

	}

	public List<Error> getErrors() {
		return errors;
	}

	public Object getBaseRequest() {
		return baseRequest;
	}
}
