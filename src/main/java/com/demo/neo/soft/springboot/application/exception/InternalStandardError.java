package com.demo.neo.soft.springboot.application.exception;

import org.springframework.http.HttpStatus;

public enum InternalStandardError {
	 USER_DELETED_SUCESSFULLY("User deleted successfully..!",HttpStatus.OK,"2001"),
	 USER_UPDATED_SUCCESSFULLY("User updated sucessfully..!", HttpStatus.OK, "200"),
	 UNAUTHORIZED("Unauthorized exception",HttpStatus.UNAUTHORIZED,"4000"),
	 USER_NOT_FOUND("User Not exist", HttpStatus.NOT_FOUND, "4001");

    private String errorMessage;
    private HttpStatus status;
    private String errorCode;
    
	private InternalStandardError(String errorMessage, HttpStatus status, String errorCode) {
		this.errorMessage = errorMessage;
		this.status = status;
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getErrorCode() {
		return errorCode;
	}
    
    
}