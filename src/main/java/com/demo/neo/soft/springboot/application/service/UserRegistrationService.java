package com.demo.neo.soft.springboot.application.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.demo.neo.soft.springboot.application.entity.UserRegistration;
import com.demo.neo.soft.springboot.application.model.ResponseObject;

public interface UserRegistrationService {

	public ResponseObject saveUser(UserRegistration userEntity);
	
	public List<UserRegistration> getUsers();
	
	public List<UserRegistration> sortDob(@RequestParam String val);
	
	public List<UserRegistration> sortbyjoining(String val);
	
	public UserRegistration getUsersByFirstName(String firstName);
	
	public UserRegistration getUsersByPincode(String pincode);
	
	public String deleteUsers(String userId);
	
	public String updateUsers(UserRegistration entity, String userId);
	
}
