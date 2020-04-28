package com.mt.temperature.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorModel {
	
	private HttpStatus httpStatus;
	
	private LocalDateTime timestamp;
	
	private String message;
	
	private String details;
	
	public ErrorModel(HttpStatus httpStatus, String message, String details) {
        this.httpStatus = httpStatus;
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
    }
}
