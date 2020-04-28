package com.mt.temperature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NumberNotFoundException.class)
	public ResponseEntity<ConversionError> mapException(NumberNotFoundException ex) {
		ConversionError error = new ConversionError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return new ResponseEntity<ConversionError>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
