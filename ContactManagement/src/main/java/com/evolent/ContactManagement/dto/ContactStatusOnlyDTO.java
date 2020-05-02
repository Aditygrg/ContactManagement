package com.evolent.ContactManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactStatusOnlyDTO {

	@JsonProperty(required=true)
	private boolean status;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
