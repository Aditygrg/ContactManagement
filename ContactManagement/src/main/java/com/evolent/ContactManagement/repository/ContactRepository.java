package com.evolent.ContactManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.evolent.ContactManagement.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{

	List<Contact> findAllByStatus(boolean b);
	
	List<Contact> findAll();
	
	@Query("select c.emailId from Contact c where lower(c.emailId) = lower(:emailId)")
	String getEmailAddress(@Param("emailId")String emailId);
	
	@Query("select c.phoneNo from Contact c where c.phoneNo = :phoneNo")
	String getPhoneNo(@Param("phoneNo")String phoneNo);
}
