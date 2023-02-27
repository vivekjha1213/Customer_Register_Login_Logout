package com.App.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.model.CurrentUserSession;




@Repository
public interface CustomerLoginSessionDAO extends JpaRepository<CurrentUserSession, Integer> {

    public Optional<CurrentUserSession>  findByCustomerId(Integer customberId);
	
	public Optional<CurrentUserSession>  findByUuid(String uuid);
	
	
}
