package com.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.model.Customer;


@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	
	public Customer findByMobile(String mobile);

	public Customer findByEmail(String email);

	
}
