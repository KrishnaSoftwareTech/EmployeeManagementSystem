package com.EmployeeManagmentSystem.Rest.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author krishnakumar
 *
 */
@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)

public class DataProcessingException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String message;
	/**
	 * @param message
	 */
	public DataProcessingException(String message) {
		super();
		this.message = message;
	}
	public DataProcessingException() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
