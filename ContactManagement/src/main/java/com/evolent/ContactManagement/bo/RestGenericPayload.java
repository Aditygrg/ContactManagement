package com.evolent.ContactManagement.bo;

import com.evolent.ContactManagement.constant.EntityAction;
import com.evolent.ContactManagement.constant.EntityType;

public class RestGenericPayload {
	
	private EntityType entityType;
	
	private EntityAction entityAction;
	
	private String entityId;

	public EntityType getEntityType() {
		return entityType;
	}

	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}

	public EntityAction getEntityAction() {
		return entityAction;
	}

	public void setEntityAction(EntityAction entityAction) {
		this.entityAction = entityAction;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public RestGenericPayload(EntityType entityType, EntityAction entityAction, String entityId) {
		super();
		this.entityType = entityType;
		this.entityAction = entityAction;
		this.entityId = entityId;
	}

}
