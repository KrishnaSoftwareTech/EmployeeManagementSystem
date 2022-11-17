package com.EmployeeManagmentSystem.Rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.EmployeeManagmentSystem.Rest.Model.EmpCompanyBranchDetails;

/**
 * @author krishnakumar
 *
 */
public interface EmpCompanyBranchDetailsRepository extends JpaRepository<EmpCompanyBranchDetails, Long> {
  
	EmpCompanyBranchDetails findBySapid(Long sapid);
}
