package com.EmployeeManagmentSystem.Rest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagmentSystem.Rest.Model.FamilyDetails;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.FamilyDetailsInterface;

/**
 * @author krishnakumar
 *
 */
@RestController
public class FamilyInfoController {
	
	@Autowired
	private FamilyDetailsInterface familyDetails;
		
	@GetMapping
	public FamilyDetails getFamilyDetails(@PathVariable Long sapId) {
		FamilyDetails familyInfo = familyDetails.getFamilyInfo(sapId);
		return familyInfo;
		
	}
	
	@PostMapping
	public FamilyDetails postFamilyDetails(@RequestBody FamilyDetails familyInfo, @PathVariable Long sapId) {
		FamilyDetails addFamilyInfo = familyDetails.addFamilyInfo(familyInfo,sapId);
		return addFamilyInfo;
		
	}
	@PutMapping
	public FamilyDetails updateFamilyDetails() {
		return  null;
	}
	
}
