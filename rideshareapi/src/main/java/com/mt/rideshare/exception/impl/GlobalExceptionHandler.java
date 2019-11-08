package com.mt.rideshare.exception.impl;

import java.io.IOException;
import java.net.BindException;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mt.rideshare.exception.BaseRuntimeException;
import com.mt.rideshare.exception.RideShareException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RideShareException.class)
	@ResponseBody
	public ResponseEntity<Object> handleException(RideShareException exception) {
        if(exception !=null){
        	return new ResponseEntity<>(this.getError(exception), exception.getHttpStatus());
        }else{
        	return new ResponseEntity<>(new Error(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	

	
	

	private io.swagger.rideshare.model.Error getError(BaseRuntimeException exception) {

		io.swagger.rideshare.model.Error errorResponse = new io.swagger.rideshare.model.Error();

		if (exception != null && exception.getErrors() != null && exception.getErrors().size() > 0) {
			errorResponse = exception.getErrors().get(0);
			return errorResponse;

		}

		return errorResponse;
	}

	
	@ExceptionHandler(HttpServerErrorException.class)
	@ResponseBody
	public ResponseEntity<Object> handleHttpServerErrorException(HttpServerErrorException e) {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		io.swagger.rideshare.model.Error errorResponses = null;

		try {
			errorResponses = mapper.readValue(e.getResponseBodyAsString().getBytes(), io.swagger.rideshare.model.Error.class);

		} catch (IOException e1) {
			// e1.printStackTrace();
		//	logger.error(e1);
			io.swagger.rideshare.model.Error error = new io.swagger.rideshare.model.Error();
		//	error.setMessage(errorProperties.getDescription(ErrorCodes.ServiceFailed.code()));
		//	error.setDeveloperMessage(e.getResponseBodyAsString());
			error.setMessage(e.getStatusText());
			// error.addMoreInfoItem(errorResponse);
			errorResponses = error;

		}
		//logger.error("log HttpClientErrorException: " + e.getResponseBodyAsString());
		return new ResponseEntity<>(errorResponses, e.getStatusCode());
	}

	@ExceptionHandler(HttpClientErrorException.class)
	@ResponseBody
	public ResponseEntity<Object> handleHttpServerErrorException(HttpClientErrorException e) {

		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		io.swagger.rideshare.model.Error errorResponses = null;

		try {
			errorResponses = mapper.readValue(e.getResponseBodyAsString().getBytes(), io.swagger.rideshare.model.Error.class);
		} catch (IOException e1) {
			// e1.printStackTrace();
			//logger.error(e1);
			io.swagger.rideshare.model.Error error = new io.swagger.rideshare.model.Error();
		//	error.setMessage(errorProperties.getDescription(ErrorCodes.ServiceFailed.toString()));
			//error.setDeveloperMessage(e.getResponseBodyAsString());
			error.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			errorResponses = error;

		}
		/*logger.error("log HttpClientErrorException: " + e.getResponseBodyAsString());*/
		return new ResponseEntity<>(errorResponses, e.getStatusCode());

	}

	@ExceptionHandler
	public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) throws IOException {

		
		
		io.swagger.rideshare.model.Error error = new io.swagger.rideshare.model.Error();

		error.setCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));

		error.setMessage(ex.getMessage());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<Object> handleJsonMappingException(Throwable ex) {

		io.swagger.rideshare.model.Error error = new io.swagger.rideshare.model.Error();
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		 if (ex instanceof HttpRequestMethodNotSupportedException) {
			status = HttpStatus.METHOD_NOT_ALLOWED;

		} else if (ex instanceof HttpMediaTypeNotSupportedException) {
			status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
		} else if (ex instanceof HttpMediaTypeNotAcceptableException) {
			status = HttpStatus.NOT_ACCEPTABLE;

		} else if (ex instanceof MissingPathVariableException) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;

		} else if (ex instanceof MissingServletRequestParameterException) {
			status = HttpStatus.BAD_REQUEST;

		} else if (ex instanceof ServletRequestBindingException) {
			status = HttpStatus.BAD_REQUEST;

		} else if (ex instanceof ConversionNotSupportedException) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;

		} else if (ex instanceof TypeMismatchException) {
			status = HttpStatus.BAD_REQUEST;

		} else if (ex instanceof HttpMessageNotReadableException) {
			status = HttpStatus.BAD_REQUEST;

		} else if (ex instanceof HttpMessageNotWritableException) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;

		} else if (ex instanceof MethodArgumentNotValidException) {
			status = HttpStatus.BAD_REQUEST;

		} else if (ex instanceof MissingServletRequestPartException) {
			status = HttpStatus.BAD_REQUEST;

		} else if (ex instanceof BindException) {
			status = HttpStatus.BAD_REQUEST;

		}/* else if (ex instanceof NoHandlerFoundException) {
			status = HttpStatus.NOT_FOUND;

		}*/ else if (ex instanceof AsyncRequestTimeoutException) {
			status = HttpStatus.SERVICE_UNAVAILABLE;

		} else {
		/*	logger.warn("Unknown exception type: " + ex.getClass().getName());*/
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		error.setCode(String.valueOf(status.value()));

		error.setMessage(ex.getMessage());

		return new ResponseEntity<>(error, status);
	}


}
