package com.EmployeeManagmentSystem.Rest.Controller;

import java.util.Optional;

import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagmentSystem.Rest.Model.EmpPersonalDetails;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.PersonalDetailsInterface;

/**
 * @author krishnakumar
 *
 */
@RestController
@RequestMapping("api/service/")
public class PersonalDetailsInformationController {

	@Autowired
	private PersonalDetailsInterface perosnal_Information;
	
	@GetMapping("/Employees/{sapid}/EmployeeInfo/personalDetails")
	public ResponseEntity<EmpPersonalDetails> getPersonalDetails(@PathVariable Long sapid) {
		Optional<EmpPersonalDetails> personalDetails = perosnal_Information.getPersonalDetails(sapid);
		if(null == personalDetails) {
			return new ResponseEntity<EmpPersonalDetails>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(personalDetails.get());
	}
	@PostMapping("/Employees/{sapid}/EmployeeInfo/personalDetails")
	public ResponseEntity<EmpPersonalDetails> addPersonalDetails(@RequestBody EmpPersonalDetails personalDetails,@PathVariable Long sapid){
		perosnal_Information.addPersonalDetails(personalDetails,sapid);
		return null;
		
	}
}
