package com.EmployeeManagmentSystem.Rest.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author krishnakumar
 *
 */
@ResponseStatus(value=HttpStatus.CONFLICT)
public class AlreadyExitsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	/**
	 * @param httpStatus
	 * @param message
	 */
	public AlreadyExitsException(String message) {
		super();
		this.setMessage(message);
		}
	
	public AlreadyExitsException() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
