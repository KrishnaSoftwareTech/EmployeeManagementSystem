package com.EmployeeManagmentSystem.Rest.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author krishnakumar
 *
 */
@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED)
public class SchemaProcessingException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String messasge;

	public SchemaProcessingException(String message) {
		super(message);
		this.messasge=message;
	}
	public SchemaProcessingException() {
		
	}

}
