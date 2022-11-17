package com.EmployeeManagmentSystem.Rest.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author krishnakumar
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request,HttpStatus HttpStatus) {
	        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false), HttpStatus);
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }

	 @ExceptionHandler(AlreadyExitsException.class)
	    public ResponseEntity<?> alreadyExitsException(AlreadyExitsException ex, WebRequest request,HttpStatus HttpStatus) {
	        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false),HttpStatus);
	        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
	    }

	 
	 @ExceptionHandler(BadRequestException.class)
	    public ResponseEntity<?> badRequestException(BadRequestException ex, WebRequest request,HttpStatus HttpStatus) {
	        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false),HttpStatus);
	        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	    }
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request,HttpStatus HttpStatus) {
	        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false),HttpStatus);
	        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
