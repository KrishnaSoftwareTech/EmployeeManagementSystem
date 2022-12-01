package com.EmployeeManagmentSystem.Rest.ServiceInterface;

import com.EmployeeManagmentSystem.Rest.Model.EmpHRCompensation;

/**
 * @author krishnakumar
 *
 */
public interface HrCompensationServiceInterface {

	public EmpHRCompensation getCompensationInfo(Long sapid);

	public EmpHRCompensation addCompensationDetails(Long sapid, EmpHRCompensation compensationinfo);

	public EmpHRCompensation updateCompensationDetials(Long sapid, EmpHRCompensation compensationinfo);

}
