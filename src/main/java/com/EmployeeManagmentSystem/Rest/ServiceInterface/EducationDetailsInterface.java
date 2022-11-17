package com.EmployeeManagmentSystem.Rest.ServiceInterface;

import java.util.Optional;

import com.EmployeeManagmentSystem.Rest.Exception.InternalServerException;
import com.EmployeeManagmentSystem.Rest.Model.EducationDetails;

/**
 * @author krishnakumar
 *
 */
public interface EducationDetailsInterface {

	public Optional<EducationDetails> getEmployeeEducationInfo(Long sapId) throws InternalServerException;
	public EducationDetails addEmployeeEducationinfo(Long sapId,EducationDetails educationInfo);
	public void updateEducationInfo(Long sapId, EducationDetails educationDetails);
	public void deleteEducationInfo(Long sapId);
}
