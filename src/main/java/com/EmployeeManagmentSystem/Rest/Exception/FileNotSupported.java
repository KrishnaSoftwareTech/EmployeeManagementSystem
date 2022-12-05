package com.EmployeeManagmentSystem.Rest.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author krishnakumar
 *
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class FileNotSupported  extends RuntimeException{

	private static final long serialVersionUID = 1L;
    
	private String message;
	private HttpStatus status;
	
	/**
	 * @param message
	 * @param status
	 */
	public FileNotSupported(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}
	public FileNotSupported(String message) {
		super();
		this.message = message;
	}
	
	public FileNotSupported() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
}
