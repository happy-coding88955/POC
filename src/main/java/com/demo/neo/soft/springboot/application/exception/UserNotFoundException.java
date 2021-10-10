package com.demo.neo.soft.springboot.application.exception;

public class UserNotFoundException extends UserServiceException{

	public UserNotFoundException() {
		super(InternalStandardError.USER_NOT_FOUND);
	}
}
