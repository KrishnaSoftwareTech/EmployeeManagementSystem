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

import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;
import com.EmployeeManagmentSystem.Rest.Model.EmpCompanyBranchDetails;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.BankDetailsInterface;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.CompanyBranchInterface;

/**
 * @author krishnakumar
 *    Employees/{SapId}/EmployeeInfo/EducationDetails
 *    /api/service/Employees/14898912/EmployeeInfo/BankDetails
 */
@RestController
@RequestMapping("api/service/")
public class BankInformationController {
 // String url="/Employees/{sapid}/EmployeeInfo/BankDetails";
	@Autowired
	private BankDetailsInterface bankDetails;
	@RequestMapping
	
	@GetMapping("/Employees/{sapid}/EmployeeInfo/BankDetails")
	 public Optional<EmpBankDetails> getEmployeeBankDetails(@PathVariable Long sapid) {
		Optional<EmpBankDetails> bankDetails2 = bankDetails.getBankDetails(sapid);
		return bankDetails2;
	}

	@PostMapping("/Employees/{EmployeeId}/EmployeeInfo/BankDetails")
	public EmpBankDetails addBankDetails(@RequestBody EmpBankDetails bankInfo,@PathVariable Long EmployeeId) {
		EmpBankDetails saveBankInfo = bankDetails.saveBankInfo(bankInfo ,EmployeeId);
		return saveBankInfo;
	}
	
	
	@PutMapping("/Employees/{EmployeeId}/EmployeeInfo/BankDetails")
	public EmpBankDetails updateBankDetails(@RequestBody EmpBankDetails bankInfo,@PathVariable Long EmployeeId) {
		EmpBankDetails saveBankInfo = bankDetails.updateBankInfo(bankInfo ,EmployeeId);
		return saveBankInfo;
	}
	
	@DeleteMapping("/Employees/{sapId}/EmployeeInfo/BankDetails")
	public ResponseEntity<String> deleteBankDetailsOfEmployee(@PathVariable Long sapId){
		 bankDetails.deleteBankDetails(sapId);
	//	return ResponseEntity(HttpStatus.OK ,"BankDetails Deleted for Employee "+sapId);
		return ResponseEntity.ok().header("Bank Details Removed for Employee" ,sapId.toString()).body(sapId.toString()) ;
	}
	
}
