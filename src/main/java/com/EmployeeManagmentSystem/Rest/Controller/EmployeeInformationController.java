package com.EmployeeManagmentSystem.Rest.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.BankDetailsInterface;

/**
 * @author krishnakumar
 *    Employees/{SapId}/EmployeeInfo/EducationDetails
 */
@RestController
@RequestMapping("api/service/")
public class EmployeeInformationController {

	@Autowired
	private BankDetailsInterface bankDetails;
	
	@GetMapping("/Employees/{sapid}/EmployeeInfo/BankDetails")
	 public Optional<EmpBankDetails> getEmployeeBankDetails(@PathVariable Long sapid) {
		Optional<EmpBankDetails> bankDetails2 = bankDetails.getBankDetails(sapid);
		return bankDetails2;
	}

}
