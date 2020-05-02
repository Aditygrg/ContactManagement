package com.evolent.ContactManagement.constant;

import org.springframework.http.HttpStatus;

public enum ExceptionCode {
	
	SOMETHING_WENT_WRONG("Something went wrong"),
	
	INVALID_REQUEST_BODY("Invalid Request Body"),
	
	FIELD_ALREADY_EXIST("%s already exist"),
	
	EMPTY_FIELD("%s is blank"),
	
	INVALID_FIELD("%s is invalid"),
	
	CONTACT_NOT_FOUND("Contact not found",HttpStatus.NOT_FOUND),
	
	ID_UNMATCHED("Contact id should match with payload");

	private String description;
	
	private HttpStatus httpStatus;

	private ExceptionCode(String description, HttpStatus httpStatus) {
		this.description = description;
		this.httpStatus = httpStatus;
	}

	private ExceptionCode(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
	
}
