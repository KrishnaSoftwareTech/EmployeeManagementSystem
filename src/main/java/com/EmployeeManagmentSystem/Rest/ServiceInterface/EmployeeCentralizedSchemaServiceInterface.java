package com.EmployeeManagmentSystem.Rest.ServiceInterface;

import java.util.List;

import com.EmployeeManagmentSystem.Rest.Model.EmployeeCentralizedSchemas;

/**
 * @author krishnakumar
 *
 */
public interface EmployeeCentralizedSchemaServiceInterface {

	public List<Object> getAllSchema(Long sapid);
}
