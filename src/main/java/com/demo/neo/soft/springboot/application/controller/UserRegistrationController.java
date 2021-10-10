package com.demo.neo.soft.springboot.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.neo.soft.springboot.application.entity.UserRegistration;
import com.demo.neo.soft.springboot.application.model.ResponseObject;
import com.demo.neo.soft.springboot.application.service.impl.UserRegistrationServiceImpl;


@RestController
@RequestMapping("/api/v1")
public class UserRegistrationController {
	
		@Autowired
		UserRegistrationServiceImpl service;
  
		@ResponseStatus(HttpStatus.CREATED)
		@PostMapping("/addusers")
		public ResponseObject addUsers(@Valid @RequestBody UserRegistration users) {
			return service.saveUser(users);
		}

		@GetMapping("/users")
		public List<UserRegistration> findAllUsers(){
			return service.getUsers();
		}

		@GetMapping("users/asc")
		public List<UserRegistration> findSortDob(@RequestParam String val){
			return service.sortDob(val);
		}

		@GetMapping("/users/desc")
		public List<UserRegistration> sortByJoinDate(@RequestParam String val){
			return service.sortbyjoining(val);
		}

		@GetMapping("/users/{firstName}")
		public UserRegistration findUsersByName(@PathVariable String firstName) {
			return service.getUsersByFirstName(firstName);
		}

		@GetMapping("/user/{pincode}")
		public UserRegistration findUsersByPincode(@PathVariable String pincode) {
			return service.getUsersByPincode(pincode);
		}


		@PutMapping("/users/{userId}")
		public String updateUsers( @RequestBody UserRegistration users, @PathVariable String userId)  
		{
			return service.updateUsers(users, userId);

		}

		@DeleteMapping("/users/{userId}")
		public String deleteUsers(@PathVariable String userId) {
			return service.deleteUsers(userId);
		}

		@DeleteMapping("/user/{userId}")
		public String deleteUser(@PathVariable String userId) {
			return service.deleteUser(userId);
		}

	}