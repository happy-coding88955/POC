package com.demo.neo.soft.springboot.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.neo.soft.springboot.application.entity.UserRegistration;

@Repository
public interface UserRegistrationRepository extends JpaRepository<UserRegistration,String>{
	
	Optional<UserRegistration> findByFirstName(String firstName);

	Optional<UserRegistration> findByPincode(String pincode);
	
}