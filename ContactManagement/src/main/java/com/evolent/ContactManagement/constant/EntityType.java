package com.evolent.ContactManagement.constant;

public enum EntityType {
	
	Contact("Contact");
	
	private String entityName;

	private EntityType(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

}
