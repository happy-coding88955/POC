package com.demo.neo.soft.springboot.application.exception;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.neo.soft.springboot.application.model.ResponseObject;


@RestControllerAdvice
public class AppExceptionHandler {
	
	 @ExceptionHandler(UserServiceException.class)
	    public ResponseEntity<ResponseObject> handleUserServiceException(UserServiceException exception) {
	   
	        return ResponseEntity.status(exception.getError().getStatus())
	                .body(ResponseObject.builder()
	                        .status(exception.getError().getStatus().toString())
	                        .data("Error occurred..")
	                        .build());
	    }

	    @ExceptionHandler(Exception.class)
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public ResponseObject handleException(Exception exception) {
	
	        return ResponseObject.builder()
	                .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
	                .data("Error occurred..")
	                .build();
	    }
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public Map<String, String> handleValidationExceptions(
	      MethodArgumentNotValidException ex) {
	        Map<String, String> errors = new HashMap<>();
	        ex.getBindingResult().getAllErrors().forEach((error) -> {
	            String fieldName = ((FieldError) error).getField();
	            String errorMessage = error.getDefaultMessage();
	            errors.put(fieldName, errorMessage);
	        });
	        return errors;
	    }
	}
