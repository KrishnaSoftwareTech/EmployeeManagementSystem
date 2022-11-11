package com.EmployeeManagmentSystem.Rest.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author krishnakumar
 *
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String message;
	public BadRequestException() {
		
	}
	public BadRequestException(String message) {
			super(message);
			this.message=message;
	}
//	public BadRequestException(HttpStatus conflict, String string) {
//		super(string);
//		this.message=string;
//	}

}
