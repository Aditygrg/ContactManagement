package com.evolent.ContactManagement.util;

import com.evolent.ContactManagement.constant.ExceptionCode;
import com.evolent.ContactManagement.dto.ContactDTO;
import com.evolent.ContactManagement.exception.RestOperationFailedException;

public class Validate {
	
	public static boolean isContactValid(ContactDTO contactDTO) {
		if(isStringNullOrEmpty(contactDTO.getFirstName()))
		restException(ExceptionCode.EMPTY_FIELD, "First Name");
		else if(isStringNullOrEmpty(contactDTO.getLastName())) {
			restException(ExceptionCode.EMPTY_FIELD, "Last Name");
		}
		if(isStringNullOrEmpty(contactDTO.getEmailId()))
			restException(ExceptionCode.EMPTY_FIELD, "Email Id");
		else if(isStringNullOrEmpty(contactDTO.getPhoneNo())) {
			restException(ExceptionCode.EMPTY_FIELD, "Phone no");
		}
		else if(!isPatternMatch(contactDTO.getPhoneNo(), "^\\+{0,1}(?:[0-9-#()] ?){6,22}[0-9-#()]$")) {
			restException(ExceptionCode.INVALID_FIELD,"Phone no");
		}
		else if(!isPatternMatch(contactDTO.getEmailId(), "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
			restException(ExceptionCode.INVALID_FIELD,"Email Id");
		}
		
		return true;
	}
	
	public static boolean isStringNullOrEmpty(String str) {
		return str == null || str.trim().isEmpty(); 
	}
	
	public static boolean isPatternMatch(String s, String pattern) {
		return s.matches(pattern);
	}
	
	public static void restException(ExceptionCode e) {
		throw new RestOperationFailedException(e,e.getDescription());
	}
	
	public static void restException(ExceptionCode e,Object ... errorMsgParams) {
		throw new RestOperationFailedException(e,String.format(e.getDescription(), errorMsgParams));
	}
	

}
