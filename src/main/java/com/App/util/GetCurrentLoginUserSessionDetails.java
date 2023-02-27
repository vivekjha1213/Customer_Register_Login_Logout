package com.App.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.App.model.CurrentUserSession;
import com.App.model.Customer;
import com.App.repository.CustomerDao;
import com.App.repository.CustomerLoginSessionDAO;

@Component
public class GetCurrentLoginUserSessionDetails {

	@Autowired
	private CustomerLoginSessionDAO sessionDAO;

	@Autowired
	private CustomerDao customerDAO;
	
	
	
	
	public CurrentUserSession getCurrentUserSession(String key) {
		Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);
		
		return optional.get();
	}
	
	
	
	public Integer getCurrentUserSessionId(String key) {
		Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);
		
		return optional.get().getId();
	}
	
	
	
	public Customer getCurrentCustomer(String key) {
		Optional<CurrentUserSession> optional = sessionDAO.findByUuid(key);
		
		Integer customerId = optional.get().getCustomerId();
		
		return  customerDAO.getById(customerId);
	}
	
	
	
}
