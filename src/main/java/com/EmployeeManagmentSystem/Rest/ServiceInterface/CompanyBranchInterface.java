package com.EmployeeManagmentSystem.Rest.ServiceInterface;

import java.util.Optional;

import com.EmployeeManagmentSystem.Rest.Model.EmpCompanyBranchDetails;

/**
 * @author krishnakumar
 *
 */
public interface CompanyBranchInterface {

	public Optional<EmpCompanyBranchDetails> getBranchDetails(Long sapid);

}
