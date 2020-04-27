package com.evolent.ContactManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactStatusOnlyDTO {
	
	private Long id;

	@JsonProperty(required=true)
	private boolean status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
