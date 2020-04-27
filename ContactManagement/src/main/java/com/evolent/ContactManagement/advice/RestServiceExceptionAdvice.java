package com.evolent.ContactManagement.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LocationAwareLogger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.evolent.ContactManagement.bo.RestExceptionResponse;
import com.evolent.ContactManagement.constant.ExceptionCode;
import com.evolent.ContactManagement.exception.RestOperationFailedException;

@ControllerAdvice
public class RestServiceExceptionAdvice {
	
	private static Logger logger = LogManager.getLogger(RestServiceExceptionAdvice.class);
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<RestExceptionResponse> handleUncaughtException(Throwable e){
		e.printStackTrace();
		logger.error("Something went wrong in rest api " + e.getCause());
		
		RestExceptionResponse exceptionResponse = new RestExceptionResponse(ExceptionCode.SOMETHING_WENT_WRONG.getDescription(),HttpStatus.INTERNAL_SERVER_ERROR);
		
		return ResponseEntity.status(exceptionResponse.getStatus())
				.contentType(MediaType.APPLICATION_JSON)
				.body(exceptionResponse);
		
	}

	@ExceptionHandler(RestOperationFailedException.class)
	public ResponseEntity<RestExceptionResponse> handleRestException(RestOperationFailedException e){
		
		RestExceptionResponse exceptionResponse;
		
		if(e.getExceptionCode().getHttpStatus() != null) {
			if(e.getExceptionCode().getHttpStatus() == HttpStatus.INTERNAL_SERVER_ERROR)
			logger.error("Something went wrong in rest api " + e.getCause());
			exceptionResponse = new RestExceptionResponse(e.getMessage(), e.getExceptionCode().getHttpStatus());
		}
		else {
			exceptionResponse = new RestExceptionResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.status(exceptionResponse.getStatus())
				.contentType(MediaType.APPLICATION_JSON)
				.body(exceptionResponse);
		
	}
}
