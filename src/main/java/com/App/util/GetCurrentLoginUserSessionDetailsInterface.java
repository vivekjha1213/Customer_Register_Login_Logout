package com.App.util;

import com.App.model.CurrentUserSession;
import com.App.model.Customer;

public interface GetCurrentLoginUserSessionDetailsInterface {

	  public CurrentUserSession getCurrentUserSession(String key);
		
		public Integer getCurrentUserSessionId(String key);
		
		public Customer getCurrentCustomer(String key);
	
	
}
