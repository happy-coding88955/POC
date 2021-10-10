package com.demo.neo.soft.springboot.application.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.neo.soft.springboot.application.entity.UserRegistration;
import com.demo.neo.soft.springboot.application.exception.InternalStandardError;
import com.demo.neo.soft.springboot.application.exception.UserServiceException;
import com.demo.neo.soft.springboot.application.model.ResponseObject;
import com.demo.neo.soft.springboot.application.repository.UserRegistrationRepository;
import com.demo.neo.soft.springboot.application.service.UserRegistrationService;
import com.demo.neo.soft.springboot.application.exception.UserNotFoundException;



@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	@Autowired
	UserRegistrationRepository repository;

	public ResponseObject saveUser(UserRegistration userEntity) {
		
		return ResponseObject.builder().status("User data  saved: " + repository.save(userEntity)).build();
	}

	public List<UserRegistration> getUsers() {
		return repository.findAll();
	}

	public List<UserRegistration> sortDob(@RequestParam String val) {
		return repository.findAll(Sort.by(Direction.ASC, val));
	}

	public List<UserRegistration> sortbyjoining(String val) {
		return repository.findAll(Sort.by(Direction.DESC, val));
	}

	public UserRegistration getUsersByFirstName(String firstName) {
		Optional<UserRegistration> optionalUser = repository.findByFirstName(firstName);
		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException();	
		}
		UserRegistration userRegistration = optionalUser.get();
		return userRegistration;
	}

	public UserRegistration getUsersByPincode(String pincode) {
		
		Optional<UserRegistration> optionalUser = repository.findByPincode(pincode);
		if (!optionalUser.isPresent()) {
			throw new  UserServiceException(InternalStandardError.USER_NOT_FOUND);
		}
		UserRegistration userRegPincode = optionalUser.get();
		return userRegPincode;
		
	}

	public String deleteUser(String userId) {
		return "users deleted !!" + userId;
	}

	public String deleteUsers(String userId) {
		if(userId.isEmpty()) {
			throw new  UserServiceException(InternalStandardError.USER_NOT_FOUND);	
		}
		repository.deleteById(userId);
		return new UserServiceException(InternalStandardError.USER_DELETED_SUCESSFULLY) + userId;
	}

	public String updateUsers(UserRegistration entity, String userId) {
		Optional<UserRegistration> users = repository.findById(userId);

		if (users.isPresent()) {
			UserRegistration newEntity = users.get();
			newEntity.setEmailId(entity.getEmailId());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());
			newEntity.setAddress(entity.getAddress());
			newEntity.setContactNo(entity.getContactNo());
			newEntity.setDesignation(entity.getDesignation());
			newEntity.setDob(entity.getDob());
			newEntity.setJoinDate(entity.getJoinDate());
			newEntity.setPincode(entity.getPincode());

			newEntity = repository.save(newEntity);

			return new UserServiceException(InternalStandardError.USER_UPDATED_SUCCESSFULLY) + userId;
		} else {
			throw new UserServiceException(InternalStandardError.USER_NOT_FOUND);
		}

	}

}
