package com.EmployeeManagmentSystem.Rest.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Exception.ResourceNotFoundException;
import com.EmployeeManagmentSystem.Rest.Model.EmpPersonalDetails;
import com.EmployeeManagmentSystem.Rest.Model.FamilyDetails;
import com.EmployeeManagmentSystem.Rest.Repository.EmpFamilyDetailsRepository;
import com.EmployeeManagmentSystem.Rest.Repository.EmpPersonalDetailsRepository;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.PersonalDetailsInterface;
@Service
public class PersonalDetailsService implements PersonalDetailsInterface{

	private static final Logger log=LoggerFactory.getLogger(PersonalDetailsService.class);
	@Autowired
	private EmpPersonalDetailsRepository personalDetailsRepo;
	@Autowired
	private EmpFamilyDetailsRepository familyDetailsRepo;
	
	@Override
	public EmpPersonalDetails getPersonalDetails(Long sapid) {
		List<FamilyDetails> familyDetails=new ArrayList<FamilyDetails>();
		EmpPersonalDetails personalDetails = personalDetailsRepo.findById(sapid)
				.orElseThrow(() -> new ResourceNotFoundException("personalDetails  Not Found for " + sapid));;
		if (personalDetails.getFamilyDetails()==null) {
			try {
			List<FamilyDetails> findBySapId = familyDetailsRepo.findBySapId(sapid);
			familyDetails.addAll(findBySapId);
			personalDetails.setFamilyDetails(familyDetails);
			return personalDetails;
			}catch (Exception e) {
			throw new ResourceNotFoundException("personalDetails  Not Found for "+sapid);
			}
		}else
		return personalDetails;
	}
	
//	//@Override
//	public EmpPersonalDetails addPersonalDetails1(EmpPersonalDetails personalDetails, Long sapid) {
//		List<FamilyDetails> familyDetails=new ArrayList<FamilyDetails>();
//	     EmpPersonalDetails details=new EmpPersonalDetails();
//			     details.setCitizen(personalDetails.getCitizen()); 
//			     details.setCountryOfBirth(personalDetails.getCountryOfBirth());
//			     details.setDateOfBirth(personalDetails.getDateOfBirth());
//			     details.setFirstName(personalDetails.getFirstName());
//			     details.setGender(personalDetails.getGender());
//			     details.setLastName(personalDetails.getLastName());
//			     details.setMaritualStatus(personalDetails.getMaritualStatus());
//			     details.setMiddleName(personalDetails.getMiddleName());
//			     details.setNationality(personalDetails.getNationality());
//			     details.setStateOfBirth(personalDetails.getStateOfBirth());
//			     details.setSapId(sapid);
//			 personalDetailsRepo.save(details);
//		try {
//		//	personalDetails.setFamilyDetails(personalDetails.getSapId());.setSapId(sapid);
//			familyDetails.addAll(personalDetails.getFamilyDetails());
//			familyDetailsRepo.saveAll(familyDetails);
//		}catch (InternalServerException e) {
//			System.out.println(e);
//		}
//		return null;
//	}
	@Override
	public EmpPersonalDetails addPersonalDetails(EmpPersonalDetails personalDetails, Long sapid) {
		try {
			personalDetails.setSapId(sapid);
			personalDetailsRepo.save(personalDetails);
		}catch (RuntimeException e) {
			log.info("error during adding personal details  - > {}"+sapid);
			throw new RuntimeException("Error during adding an personal details ---- " + e.getLocalizedMessage());
		}
		return personalDetails;
	}

	//@Override
	public EmpPersonalDetails updatePersonalInfo1(EmpPersonalDetails personalDetails, Long sapid) {
		EmpPersonalDetails getPersonalDetails ;
		List<FamilyDetails> updateFamilyDetails = null;
		personalDetails.setSapId(sapid);
		personalDetails.setFamilyDetails(personalDetails.getFamilyDetails());
		try{
			//get
			 getPersonalDetails = personalDetailsRepo.findById(sapid).
					orElseThrow(() -> new ResourceNotFoundException("personalDetails  Not Found for " + sapid));;
					List<FamilyDetails> familyDetails = personalDetails.getFamilyDetails();
					if(familyDetails != null) {
						 personalDetails.setFamilyDetails(personalDetails.getFamilyDetails());
						 updateFamilyDetails = familyDetailsRepo.saveAll(familyDetails);
					}
					else {
						//if null get family details and set 
					}
				//	getPersonalDetails.setSapId(sapid);
					getPersonalDetails.setCitizen(personalDetails.getCitizen());
					getPersonalDetails.setCountryOfBirth(personalDetails.getCountryOfBirth());
					getPersonalDetails.setDateOfBirth(personalDetails.getDateOfBirth());
					getPersonalDetails.setFamilyDetails(updateFamilyDetails);
					getPersonalDetails.setFirstName(personalDetails.getFirstName());
					getPersonalDetails.setLastName(personalDetails.getLastName());
					getPersonalDetails.setMiddleName(personalDetails.getMiddleName());
					getPersonalDetails.setGender(personalDetails.getGender());
					getPersonalDetails.setMaritualStatus(personalDetails.getMaritualStatus());
					getPersonalDetails.setNationality(personalDetails.getNationality());
					getPersonalDetails.setStateOfBirth(personalDetails.getStateOfBirth());
			//update		
			personalDetailsRepo.save(getPersonalDetails);
		}catch (RuntimeException e) {
			log.info("error during updation of personal details  - > {}"+sapid);
			throw new RuntimeException("Error during updation an personal details ---- " + e.getLocalizedMessage());
		}
		return getPersonalDetails;
	}
//we cannot delete personal details without deleteing family details - and if family details null  we can  delete 
	@Override
	public void deletePersonalInfoById(Long sapid) {
		try {
			//familyDetailsRepo.deleteById(sapid);
			personalDetailsRepo.deleteById(sapid);
			log.warn("Deleted Personal Information for -> { }"+sapid);
		}catch (ResourceNotFoundException e) {
			log.info("error during deleting personal details  - > {}"+sapid);
			throw new ResourceNotFoundException("Error during deleting an personal details ---- " + e.getLocalizedMessage());
		}
	}
	@Override
	public EmpPersonalDetails updatePersonalInfo(EmpPersonalDetails personalDetails, Long sapid) {
		try {
			personalDetails.setSapId(sapid);
			personalDetailsRepo.save(personalDetails);
		}catch (RuntimeException e) {
			log.info("error during adding personal details  - > {}"+sapid);
			throw new RuntimeException("Error during adding an personal details ---- " + e.getLocalizedMessage());
		}
		return personalDetails;
	}
}
