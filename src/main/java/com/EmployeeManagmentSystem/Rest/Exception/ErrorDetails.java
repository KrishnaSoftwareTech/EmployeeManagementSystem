package com.EmployeeManagmentSystem.Rest.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

/**
 * @author krishnakumar
 *
 */
public class ErrorDetails {
	private Date timestamp;
    private String message;
    private String details;
    private HttpStatus HttpStatus;

    public ErrorDetails(Date timestamp, String message, String details,HttpStatus HttpStatus) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.HttpStatus=HttpStatus;
    }

    public ErrorDetails(Date date, String message2, String description) {
	}

	public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
   }

    public String getDetails() {
       return details;
   }

	public HttpStatus getHttpStatus() {
		return HttpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		HttpStatus = httpStatus;
	}

}
