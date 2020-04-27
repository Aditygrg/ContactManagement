package com.evolent.ContactManagement.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolent.ContactManagement.bo.RestGenericPayload;
import com.evolent.ContactManagement.constant.EntityAction;
import com.evolent.ContactManagement.constant.EntityType;
import com.evolent.ContactManagement.constant.ExceptionCode;
import com.evolent.ContactManagement.dto.ContactDTO;
import com.evolent.ContactManagement.dto.ContactStatusOnlyDTO;
import com.evolent.ContactManagement.entity.Contact;
import com.evolent.ContactManagement.repository.ContactRepository;
import com.evolent.ContactManagement.service.ContactService;
import com.evolent.ContactManagement.util.Validate;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepository;
	
	/*
	 * @Autowired private ModelMapper modelMapper;
	 */

	@Override
	public RestGenericPayload insert(ContactDTO contactDTO) {
		Validate.isContactValid(contactDTO);
		
		String emailId = contactRepository.getEmailAddress(contactDTO.getEmailId().trim());
		
		String phoneNo = contactRepository.getPhoneNo(contactDTO.getPhoneNo().trim());
		
		if(!Validate.isStringNullOrEmpty(emailId)) {
			Validate.restException(ExceptionCode.FIELD_ALREADY_EXIST, "Email Id");
		}
		
		if(!Validate.isStringNullOrEmpty(phoneNo)) {
			Validate.restException(ExceptionCode.FIELD_ALREADY_EXIST, "Phone No");
		}
		
		//Contact contact = modelMapper.map(contactDTO, Contact.class);
		
		Contact contact = new Contact();
		contact.setEmailId(contactDTO.getEmailId().trim());
		contact.setFirstName(contactDTO.getFirstName().trim());
		contact.setLastName(contactDTO.getLastName().trim());
		contact.setPhoneNo(contactDTO.getPhoneNo().trim());
		
		contactRepository.save(contact);
		
		return new RestGenericPayload(EntityType.Contact, EntityAction.CREATE, String.valueOf(contact.getId()));
	}

	@Override
	public RestGenericPayload update(ContactDTO contactDTO, Long id) {
		
		if(id != contactDTO.getId()) {
			Validate.restException(ExceptionCode.ID_UNMATCHED);
		}
		
		Optional<Contact> contactOpt = contactRepository.findById(contactDTO.getId());
		
		if(!contactOpt.isPresent()) {
			Validate.restException(ExceptionCode.CONTACT_NOT_FOUND);
		}
		
		Contact contact = contactOpt.get();
		Validate.isContactValid(contactDTO);
		
		String emailId = contactDTO.getEmailId().trim();
		
		String phoneNo = contactDTO.getPhoneNo().trim();
		
		if(!emailId.equalsIgnoreCase(contact.getEmailId())) {
			String existingEmailId = contactRepository.getEmailAddress(contactDTO.getEmailId().trim());
			if(!Validate.isStringNullOrEmpty(existingEmailId)) {
				Validate.restException(ExceptionCode.FIELD_ALREADY_EXIST, "Email Id");
			}	
			contact.setEmailId(emailId);
		}
		
		if(!phoneNo.equals(contact.getPhoneNo())) {
			String existingPhoneNo = contactRepository.getPhoneNo(contactDTO.getPhoneNo().trim());
			if(!Validate.isStringNullOrEmpty(existingPhoneNo)) {
				Validate.restException(ExceptionCode.FIELD_ALREADY_EXIST, "Phone No");
			}
			contact.setPhoneNo(phoneNo);
		}
		
		contact.setFirstName(contactDTO.getFirstName().trim());
		
		contact.setLastName(contactDTO.getLastName().trim());
		
		contactRepository.save(contact);
		
		return new RestGenericPayload(EntityType.Contact, EntityAction.UPDATE, String.valueOf(contact.getId()));
	}

	@Override
	public RestGenericPayload delete(Long contactId) {
	
		Optional<Contact> contactOpt = contactRepository.findById(contactId);
		if(!contactOpt.isPresent()) {
			Validate.restException(ExceptionCode.CONTACT_NOT_FOUND);
		}
		else {
			contactRepository.deleteById(contactId);
		}
		
		return new RestGenericPayload(EntityType.Contact, EntityAction.DELETE, String.valueOf(contactId));
	}

	@Override
	public RestGenericPayload activate(Long id, ContactStatusOnlyDTO contactStatusDTO) {
		
		if(id != contactStatusDTO.getId()) {
			Validate.restException(ExceptionCode.ID_UNMATCHED);
		}
		
		Optional<Contact> contactOpt = contactRepository.findById(id);
		
		if(!contactOpt.isPresent()) {
			Validate.restException(ExceptionCode.CONTACT_NOT_FOUND);
		}
		else {
			Contact contact = contactOpt.get();
			contact.setStatus(contactStatusDTO.isStatus());
			contactRepository.save(contact);
		}
		
		return new RestGenericPayload(EntityType.Contact, EntityAction.UPDATE, String.valueOf(id));
	}

}
