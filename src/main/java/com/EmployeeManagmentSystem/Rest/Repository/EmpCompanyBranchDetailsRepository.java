package com.EmployeeManagmentSystem.Rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;
import com.EmployeeManagmentSystem.Rest.Model.EmpCompanyBranchDetaila;

/**
 * @author krishnakumar
 *
 */
public interface EmpCompanyBranchDetailsRepository extends JpaRepository<EmpCompanyBranchDetaila, Long> {

}
