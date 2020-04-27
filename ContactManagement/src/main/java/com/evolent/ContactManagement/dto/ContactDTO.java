package com.evolent.ContactManagement.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.evolent.ContactManagement.constant.ExceptionCode;

public class ContactDTO {

	private Long id;
	
	//@NotBlank
	private String firstName;
	
	//@NotBlank
	private String lastName;
	
	//@NotBlank
	//@Pattern(regexp = "^[\\\\w-\\\\+]+(\\\\.[\\\\w]+)*@[\\\\w-]+(\\\\.[\\\\w]+)*(\\\\.[a-z]{2,})$")
	private String emailId;
	
	private String phoneNo;
	
	private boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
