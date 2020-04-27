package com.evolent.ContactManagement.service;

import java.util.List;

import com.evolent.ContactManagement.bo.RestGenericPayload;
import com.evolent.ContactManagement.dto.ContactDTO;
import com.evolent.ContactManagement.dto.ContactStatusOnlyDTO;
import com.evolent.ContactManagement.entity.Contact;

public interface ContactService {

	public RestGenericPayload insert(ContactDTO contactDTO);
	
	public RestGenericPayload update(ContactDTO contactDTO, Long id);
	
	public RestGenericPayload delete(Long contactId);
	
	public RestGenericPayload activate(Long contactId,ContactStatusOnlyDTO contactStatusDTO);
}
