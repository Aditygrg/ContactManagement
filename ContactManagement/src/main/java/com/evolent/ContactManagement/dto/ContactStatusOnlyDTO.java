package com.evolent.ContactManagement.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactStatusOnlyDTO {

	private boolean status;
	
	@JsonCreator
	ContactStatusOnlyDTO(@JsonProperty(value = "status", required = true) boolean status){
		this.status = status;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
