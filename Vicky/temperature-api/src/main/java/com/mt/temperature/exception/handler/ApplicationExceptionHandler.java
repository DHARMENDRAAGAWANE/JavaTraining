package com.mt.temperature.exception.handler;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends  ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorModel> handleNotFoundException(final NotFoundException exception) {
		ErrorModel errorObj = new ErrorModel(HttpStatus.NOT_FOUND,exception.getLocalizedMessage(),exception.getMessage());
		return new ResponseEntity<ErrorModel>(errorObj, HttpStatus.NOT_FOUND);
    }
	
//	@ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<Integer> handleNotFoundException(final NotFoundException exception) {
//        return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
//    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorModel errorDetails = new ErrorModel(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
//    public ResponseEntity<String> handleException(final Exception exception) {
//        return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.NOT_FOUND);
//    }
}
