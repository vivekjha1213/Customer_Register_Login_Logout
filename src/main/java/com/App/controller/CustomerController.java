package com.App.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.App.model.CurrentUserSession;
import com.App.model.Customer;
import com.App.model.CustomerDTO;
import com.App.service.CustomerLoginService;



@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerLoginService customerLoginService;
	
	
	@PostMapping("/register")
	public Customer registerCustomerHandler(@RequestBody Customer customer) {
		return customerLoginService.registerCustomer(customer);
	}
	
	
	@PostMapping("/login")
	public CurrentUserSession logInCustomerHandlre(@Valid @RequestBody CustomerDTO customerDTO ) {
		
		return customerLoginService.logIntoAccount(customerDTO);
		
	}
	
	@PatchMapping("/logout")
	public String logOutCusomerHandeler(@RequestParam(required = false) String key) {
		
	 return	customerLoginService.logOutFromAccount(key);
		
	}

// 	@GetMapping("/all")
// public Customer getCustomerByIdHandler(@PathVariable Long customerId) {
//     return customerLoginService.getCustomerById(customerId);
// }

	
}
