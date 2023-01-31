package com.EmployeeManagmentSystem.Rest.CustomResponse;

import org.springframework.http.HttpStatus;

import com.EmployeeManagmentSystem.Rest.Model.EmployeeCentralizedSchemas;

/**
 * @author krishnakumar
 *
 */
public class EmployeeCentralizedSchemasResponse {
	
	private EmployeeCentralizedSchemas schemas;
	private HttpStatus statusCode;
	/**
	 * @param schemas
	 * @param statusCode
	 */
	public EmployeeCentralizedSchemasResponse(EmployeeCentralizedSchemas schemas, HttpStatus statusCode) {
		super();
		this.schemas = schemas;
		this.statusCode = statusCode;
	}
	public EmployeeCentralizedSchemas getSchemas() {
		return schemas;
	}
	public void setSchemas(EmployeeCentralizedSchemas schemas) {
		this.schemas = schemas;
	}
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
	
	

}
