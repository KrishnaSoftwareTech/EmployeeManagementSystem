package com.EmployeeManagmentSystem.Rest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagmentSystem.Rest.Model.EmpHRCompensation;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.HrCompensationServiceInterface;

/**
 * @author krishnakumar
 * "/Employees/{sapid}/EmployeeInfo/BankDetails"
 */
@RestController
@RequestMapping("api/service/")
public class CompensationController {
	
	@Autowired
	private HrCompensationServiceInterface compensationService;
	
	@GetMapping("/Employees/{sapid}/EmployeeInfo/CompensationDetails")
	public ResponseEntity<EmpHRCompensation> getCompensationDetails(@PathVariable Long sapid){
		EmpHRCompensation compensationInfo = compensationService.getCompensationInfo(sapid);
		return ResponseEntity.ok(compensationInfo);
	}
 
	@PostMapping("")
	public ResponseEntity<EmpHRCompensation> addCompensationDetails(@PathVariable Long sapid,
			@RequestBody EmpHRCompensation compensationinfo){
		   compensationService.addCompensationDetails(sapid,compensationinfo);
				return null;
		
	}
}
