package com.EmployeeManagmentSystem.Rest.Controller;

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

import com.EmployeeManagmentSystem.Rest.Exception.InternalServerException;
import com.EmployeeManagmentSystem.Rest.Exception.ResourceNotFoundException;
import com.EmployeeManagmentSystem.Rest.Model.EmpMedicalDetails;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.MedicalDetailsInterface;

/**
 * @author krishnakumar
 *
 */
@RestController
@RequestMapping("api/service/")
public class MedicalDetailsController {

	@Autowired
	private MedicalDetailsInterface medicalService;
	
	@GetMapping("/Employees/{sapId}/EmployeeInfo/medicalInfo")
	public ResponseEntity<EmpMedicalDetails> getMedicalDetails(@PathVariable Long sapId){
		EmpMedicalDetails infoByid;
		try {
			 infoByid = medicalService.getInfoByid(sapId);
		}catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Medical Details Not Found  For" + sapId);
		}
		return ResponseEntity.ok(infoByid);
	}
	@PostMapping("/Employees/{sapId}/EmployeeInfo/medicalInfo")
	public ResponseEntity<EmpMedicalDetails> addMedicalDetails(@PathVariable Long sapId,@RequestBody EmpMedicalDetails medicalDetails){
		EmpMedicalDetails addMedicalInformation;
		try {
			 addMedicalInformation = medicalService.addMedicalInformation(medicalDetails,sapId);
		}catch (InternalServerException e) {
			throw new InternalServerException("Unable to add Medical Details " +e.getMessage());
		}
		return ResponseEntity.ok(addMedicalInformation);
	}
	@PutMapping("/Employees/{sapId}/EmployeeInfo/medicalInfo")
	public ResponseEntity<EmpMedicalDetails> updateMedicalDetails(@PathVariable Long sapId,@RequestBody EmpMedicalDetails medicalDetails){
		EmpMedicalDetails addMedicalInformation;
		try {
			 addMedicalInformation = medicalService.updateMedicalInformation(medicalDetails,sapId);
		}catch (InternalServerException e) {
			throw new InternalServerException("Unable to Update MedicalDetails "+e.getMessage());
		}
		return ResponseEntity.ok(addMedicalInformation);
	}
@DeleteMapping("/Employees/{sapId}/EmployeeInfo/medicalInfo")
	public void deleteMedicalDetails(@PathVariable Long sapId){
		try {
			  medicalService.deleteMedicalInformation(sapId);
		}catch (InternalServerException e) {
			throw new InternalServerException("Unable to Delete Medical Details "+ e.getMessage());
		}
	}
}
