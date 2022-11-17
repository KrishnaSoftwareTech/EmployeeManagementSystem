package com.EmployeeManagmentSystem.Rest.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author krishnakumar
 *
 */
@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String message;

	public InternalServerException(String message) {
		super();
		this.message=message;
	}
	public InternalServerException() {
		
	}
}
