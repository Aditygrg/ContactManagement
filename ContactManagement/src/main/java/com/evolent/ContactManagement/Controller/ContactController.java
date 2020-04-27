package com.evolent.ContactManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evolent.ContactManagement.bo.RestGenericPayload;
import com.evolent.ContactManagement.dto.ContactDTO;
import com.evolent.ContactManagement.dto.ContactStatusOnlyDTO;
import com.evolent.ContactManagement.entity.Contact;
import com.evolent.ContactManagement.repository.ContactRepository;
import com.evolent.ContactManagement.service.ContactService;

@RestController
@RequestMapping(value="/contacts")
public class ContactController {
	
	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	ContactService contactService;

	@GetMapping
	public List<Contact> getContacts(){
		//return contactRepository.findAllByStatus(true);
		return contactRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<RestGenericPayload> createContact(@RequestBody ContactDTO contactDTO){
		
		RestGenericPayload payload = contactService.insert(contactDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(payload);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RestGenericPayload> updateContact(@RequestBody ContactDTO contactDTO,@PathVariable("id") Long id){
		
		RestGenericPayload payload = contactService.update(contactDTO,id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(payload);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<RestGenericPayload> updateContact(@PathVariable("id") Long id){
		
		RestGenericPayload payload = contactService.delete(id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(payload);
		
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<RestGenericPayload> changeStatus(@PathVariable("id") Long id,@RequestBody ContactStatusOnlyDTO contactStatusDTO){
		
		RestGenericPayload payload = contactService.activate(id, contactStatusDTO);
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(payload);
		
	}
	
}
