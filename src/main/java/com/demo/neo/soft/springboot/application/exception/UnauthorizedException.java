package com.demo.neo.soft.springboot.application.exception;

public class UnauthorizedException extends UserServiceException{

	public UnauthorizedException() {
		super(InternalStandardError.UNAUTHORIZED);
	
	}

}
