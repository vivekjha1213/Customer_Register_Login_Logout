package com.App.service;

import com.App.model.CurrentUserSession;
import com.App.model.Customer;
import com.App.model.CustomerDTO;

public interface CustomerLoginService {
	
	public Customer registerCustomer(Customer customer);

	public CurrentUserSession logIntoAccount(CustomerDTO customerDTO);
	
	public String logOutFromAccount(String key);

    public Customer getCustomerById(Long customerId);
	
}
