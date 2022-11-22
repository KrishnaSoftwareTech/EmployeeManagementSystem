package com.EmployeeManagmentSystem.Rest.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Exception.InternalServerException;
import com.EmployeeManagmentSystem.Rest.Model.EmpPersonalDetails;
import com.EmployeeManagmentSystem.Rest.Model.FamilyDetails;
import com.EmployeeManagmentSystem.Rest.Repository.EmpFamilyDetailsRepository;
import com.EmployeeManagmentSystem.Rest.Repository.EmpPersonalDetailsRepository;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.PersonalDetailsInterface;
@Service
public class PersonalDetailsService implements PersonalDetailsInterface{

	@Autowired
	private EmpPersonalDetailsRepository personalDetailsRepo;
	@Autowired
	private EmpFamilyDetailsRepository familyDetailsRepo;
	//@SuppressWarnings("null")
	@Override
	public Optional<EmpPersonalDetails> getPersonalDetails(Long sapid) {
		List<FamilyDetails> familyDetails=new ArrayList<FamilyDetails>();
		Optional<EmpPersonalDetails> personalDetails = personalDetailsRepo.findById(sapid);
		//familyDetails = personalDetails.get().getFamilyDetails();
		if (personalDetails.get().getFamilyDetails()==null) {
			List<FamilyDetails> findBySapId = familyDetailsRepo.findBySapId(sapid);
			familyDetails.addAll(findBySapId);
			personalDetails.get().setFamilyDetails(familyDetails);
			return personalDetails;
		}else
		return personalDetails;
	}
	
	@Override
	public EmpPersonalDetails addPersonalDetails(EmpPersonalDetails personalDetails, Long sapid) {
		List<FamilyDetails> familyDetails=new ArrayList<FamilyDetails>();
	     EmpPersonalDetails details=new EmpPersonalDetails();
			     details.setCitizen(personalDetails.getCitizen()); 
			     details.setCountryOfBirth(personalDetails.getCountryOfBirth());
			     details.setDateOfBirth(personalDetails.getDateOfBirth());
			     details.setFirstName(personalDetails.getFirstName());
			     details.setGender(personalDetails.getGender());
			     details.setLastName(personalDetails.getLastName());
			     details.setMaritualStatus(personalDetails.getMaritualStatus());
			     details.setMiddleName(personalDetails.getMiddleName());
			     details.setNationality(personalDetails.getNationality());
			     details.setStateOfBirth(personalDetails.getStateOfBirth());
			     details.setSapId(sapid);
			 personalDetailsRepo.save(details);
		try {
		//	personalDetails.setFamilyDetails(personalDetails.getSapId());.setSapId(sapid);
			familyDetails.addAll(personalDetails.getFamilyDetails());
			familyDetailsRepo.saveAll(familyDetails);
		}catch (InternalServerException e) {
			System.out.println(e);
		}
		return null;
	}

}
