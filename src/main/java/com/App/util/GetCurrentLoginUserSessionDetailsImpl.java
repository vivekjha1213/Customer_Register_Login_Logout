package com.App.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.App.exceptions.CustomerException;
import com.App.model.CurrentUserSession;
import com.App.model.Customer;
import com.App.repository.CustomerDao;
import com.App.repository.CustomerLoginSessionDAO;



@Component
public class GetCurrentLoginUserSessionDetailsImpl implements GetCurrentLoginUserSessionDetailsInterface{

	
	@Autowired
	private CustomerLoginSessionDAO sDao;

	@Autowired
	private CustomerDao cDao;
	
	
	@Override
	public CurrentUserSession getCurrentUserSession(String key) {
		
		Optional<CurrentUserSession> opt = sDao.findByUuid(key);
		
		if(!opt.isPresent()) {
		throw new CustomerException("Unauthorized");
		}
		
		return opt.get();
		
	}

	
	
	
	@Override
	public Integer getCurrentUserSessionId(String key) {
	
		Optional<CurrentUserSession> opt = sDao.findByUuid(key);
		
		if(!opt.isPresent()) {
			throw new CustomerException("Unauthorized");
			}
			
			return opt.get().getId();
	}
	
	
	
	

	@Override
	public Customer getCurrentCustomer(String key) {
		
     Optional<CurrentUserSession> opt = sDao.findByUuid(key);
		
		if(!opt.isPresent()) {
			throw new CustomerException("Unauthorized");
			}
			
			Integer cId = opt.get().getCustomerId();
			
			return cDao.getById(cId);
		    
			
	}

}
