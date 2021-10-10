package com.demo.neo.soft.springboot.application.exception;




public class UserServiceException extends RuntimeException {

	private InternalStandardError error;

    public UserServiceException(InternalStandardError error) {
        this.error = error;
    }

	public InternalStandardError getError() {
		return error;
	}
    
    
}
