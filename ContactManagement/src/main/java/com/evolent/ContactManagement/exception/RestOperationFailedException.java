package com.evolent.ContactManagement.exception;

import com.evolent.ContactManagement.constant.ExceptionCode;

public class RestOperationFailedException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8996970034792520709L;
	
	private ExceptionCode exceptionCode;
	
	private String message;

	public ExceptionCode getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(ExceptionCode exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public RestOperationFailedException(ExceptionCode exceptionCode,String message) {
		super();
		this.exceptionCode = exceptionCode;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
