package com.EmployeeManagmentSystem.Rest.ServiceInterface;

import java.util.Optional;

import com.EmployeeManagmentSystem.Rest.Model.EmpCompanyBranchDetails;

/**
 * @author krishnakumar
 *
 */
public interface CompanyBranchInterface {

	public Optional<EmpCompanyBranchDetails> getBranchDetails(Long sapid);

	public EmpCompanyBranchDetails addBranchDetails(Long sapId, EmpCompanyBranchDetails branchDetails);

	public EmpCompanyBranchDetails updateBranchDetails(Long sapId, EmpCompanyBranchDetails branchDetails) throws InterruptedException;

	public void deleteBranchById(Long sapId);

}
