package com.EmployeeManagmentSystem.Rest.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagmentSystem.Rest.Model.EmpCompanyBranchDetails;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.CompanyBranchInterface;

/**
 * @author krishnakumar
 *
 */
@RestController
@RequestMapping("api/service/")
public class BranchInformationController {

	
	@Autowired
	private CompanyBranchInterface departmentBranch;
	
	// CompanyBranchInterface -- department 
	
		@GetMapping("/Employees/{sapId}/EmployeeInfo/branchDetails")
		public Optional<EmpCompanyBranchDetails> getBranchDetails(@PathVariable Long sapId) {
			return departmentBranch.getBranchDetails(sapId);
		}
		
		@PostMapping("/Employees/{sapId}/EmployeeInfo/branchDetails")
		public EmpCompanyBranchDetails addBranchDetails(@PathVariable Long sapId ,@RequestBody EmpCompanyBranchDetails branchDetails) {
			EmpCompanyBranchDetails addBranchDetails = departmentBranch.addBranchDetails(sapId,branchDetails);
			return addBranchDetails;
		}
		
		@PutMapping("/Employees/{sapId}/EmployeeInfo/branchDetails")
		public EmpCompanyBranchDetails updateBranchDetails(@PathVariable Long sapId ,@RequestBody EmpCompanyBranchDetails branchDetails) {
			EmpCompanyBranchDetails updateBranchDetails = null;
			try {
				updateBranchDetails = departmentBranch.updateBranchDetails(sapId,branchDetails);
			} catch (InterruptedException e) {
				throw new InternalError("Internal Server Exception");
			}
			return updateBranchDetails;
		}
		
		@DeleteMapping("/Employees/{sapId}/EmployeeInfo/branchDetails")
		public ResponseEntity<EmpCompanyBranchDetails> deleteBranch(@PathVariable Long sapId){
			departmentBranch.deleteBranchById(sapId);
			return null;
			
		}
		
}
