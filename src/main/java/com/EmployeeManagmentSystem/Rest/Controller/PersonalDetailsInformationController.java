package com.EmployeeManagmentSystem.Rest.Controller;

import java.util.Optional;

import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagmentSystem.Rest.Exception.InternalServerException;
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
		EmpPersonalDetails personalDetails = perosnal_Information.getPersonalDetails(sapid);
		if(null == personalDetails) {
			return new ResponseEntity<EmpPersonalDetails>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(personalDetails);
	}
	@PostMapping("/Employees/{sapid}/EmployeeInfo/personalDetails")
	public ResponseEntity<EmpPersonalDetails> addPersonalDetails(@RequestBody EmpPersonalDetails personalDetails,@PathVariable Long sapid){
		EmpPersonalDetails addPersonalDetails;
		try {
		 addPersonalDetails = perosnal_Information.addPersonalDetails(personalDetails,sapid);
		}catch (InternalServerException e) {
			throw new InternalServerException("Unable to add Details " + sapid);
		}
		return ResponseEntity.ok(addPersonalDetails);
	}
	@PutMapping("/Employees/{sapid}/EmployeeInfo/personalDetails")
	public ResponseEntity<EmpPersonalDetails> updatePersonalDetails(@RequestBody EmpPersonalDetails personalDetails,
						@PathVariable Long sapid){
		EmpPersonalDetails updatePersonalDetails;
		try {
			updatePersonalDetails=perosnal_Information.updatePersonalInfo(personalDetails,sapid);
		}catch (InternalServerException e) {
			throw  new InternalServerException("Unable to Update Details - > "+e.getLocalizedMessage());
		}
	return ResponseEntity.ok(updatePersonalDetails);
	}
	@DeleteMapping("/Employees/{sapid}/EmployeeInfo/personalDetails")
	public ResponseEntity<Object> deletePersonalDetails(@PathVariable Long sapid){
		try {
			perosnal_Information.deletePersonalInfoById(sapid);
		}catch (InternalServerException e) {
			throw  new InternalServerException("Unable to Update Details - > "+e.getLocalizedMessage());
		}
		return new ResponseEntity(HttpStatus.OK);
	}
}
