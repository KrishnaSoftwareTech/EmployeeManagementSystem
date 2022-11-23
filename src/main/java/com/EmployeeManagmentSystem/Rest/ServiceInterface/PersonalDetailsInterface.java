package com.EmployeeManagmentSystem.Rest.ServiceInterface;

import java.util.Optional;

import com.EmployeeManagmentSystem.Rest.Model.EmpPersonalDetails;

/**
 * @author krishnakumar
 *
 */
public interface PersonalDetailsInterface {

	public EmpPersonalDetails getPersonalDetails(Long sapid);

	public EmpPersonalDetails addPersonalDetails(EmpPersonalDetails personalDetails, Long sapid);

	public EmpPersonalDetails updatePersonalInfo(EmpPersonalDetails personalDetails, Long sapid);

	public void deletePersonalInfoById(Long sapid);

}
