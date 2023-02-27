package com.App.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.exceptions.CustomerException;
import com.App.model.CurrentUserSession;
import com.App.model.Customer;
import com.App.model.CustomerDTO;
import com.App.repository.CustomerDao;
import com.App.repository.CustomerLoginSessionDAO;
import com.App.util.GetCurrentLoginUserSessionDetailsImpl;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{

	@Autowired
	private CustomerDao cDao;
	
	
	@Autowired
	private CustomerLoginSessionDAO sDao;
	
	@Autowired
	private GetCurrentLoginUserSessionDetailsImpl currentLoginUser;
	
	
	
	
	@Override
	public Customer registerCustomer(Customer customer) {
		
	Customer c=	cDao.findByMobile(customer.getMobile());
	
	if(c==null) {
		return cDao.save(customer);
	}
	
	throw new CustomerException("User is already register");
	}
	
	
	
	
	
	
	@Override
	public CurrentUserSession logIntoAccount(CustomerDTO customerDTO) {
		
	Customer customer  = cDao.findByMobile(customerDTO.getMobile());
		
	if(customer==null) {
		throw new CustomerException("Please Enter the valid mobile Number...");
	}
	
	
	   Integer cId=  customer.getCustomerId();
	   
	 Optional<CurrentUserSession> currentUserOptional =    sDao.findByCustomerId(cId);
	     
	     if(!currentUserOptional.isEmpty()) {
	    	 throw new CustomerException("User already logged in with this number");
	     }
	     
	     
	         if(customer.getPassword().equals(customerDTO.getPassword())) {
	        	 
	        	 String key = RandomString.make(6);
	        	 
	        	 CurrentUserSession currentUserSession = new CurrentUserSession(cId, key, LocalDateTime.now());
	        	 
	        	 sDao.save(currentUserSession);
	        	 
	        	 return currentUserSession;
	         
	         }else {
	 			throw new CustomerException("Please Enter Valid Password");
	 		}
	}
	
	
	

	@Override
	public String logOutFromAccount(String key) {
		
		Optional<CurrentUserSession> currentUserOptional = 	sDao.findByUuid(key);
		
		if(currentUserOptional.isEmpty()) {
			throw new CustomerException("Customer is not logged with this number");
		}
		
       CurrentUserSession currentUserSession = currentLoginUser.getCurrentUserSession(key);
       
       sDao.delete(currentUserSession);
       
      	return "Logged Out...";
	}


}
