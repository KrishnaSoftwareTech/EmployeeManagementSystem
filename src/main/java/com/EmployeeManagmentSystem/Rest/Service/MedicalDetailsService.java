package com.EmployeeManagmentSystem.Rest.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.EmployeeManagmentSystem.Rest.Exception.InternalServerException;
import com.EmployeeManagmentSystem.Rest.Exception.ResourceNotFoundException;
import com.EmployeeManagmentSystem.Rest.Model.EmpMedicalDetails;
import com.EmployeeManagmentSystem.Rest.Repository.EmpMedicalDetailsRepository;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.MedicalDetailsInterface;

/**
 * @author krishnakumar
 *
 */
@Service
public class MedicalDetailsService implements MedicalDetailsInterface {
	
	private static final Logger logs=LoggerFactory.getLogger(MedicalDetailsService.class);

	@Autowired
	private EmpMedicalDetailsRepository medicalDetialsRepo;

	@Override
	public EmpMedicalDetails addMedicalInformation(EmpMedicalDetails medicalDetails, Long sapId) {
		EmpMedicalDetails saveInfo;
		try {
			medicalDetails.setSapId(sapId);
			saveInfo = medicalDetialsRepo.save(medicalDetails);
			logs.info("Medical Details added SuccessFully for Employee { }" ,sapId);
		}catch (InternalServerException e) {
			logs.info("Error Occured While adding Details --> { }", e.getMessage());
		  throw new InternalServerException("Error Occured While adding Details" +e.getMessage());
		}
		return saveInfo;
	}

	@Override
	public EmpMedicalDetails getInfoByid(Long sapId) {
		EmpMedicalDetails getInfo = medicalDetialsRepo.findById(sapId).orElseThrow(() -> 
						new ResourceNotFoundException("Details Not Found For " +sapId));;
		logs.info("  Details --> {}", getInfo);
		return getInfo;
	}
/// Not in use 
	@Override
	public EmpMedicalDetails updateMedicalInformation(EmpMedicalDetails medicalDetails, Long sapId) {
		 EmpMedicalDetails addMedicalInformation = null;
		medicalDetails.setSapId(sapId);
		try {
			   EmpMedicalDetails isDetailsFound = medicalDetialsRepo.findById(sapId)
					   				.orElseThrow(() ->  new ResourceNotFoundException("Details Not Found For " +sapId));;
			   isDetailsFound.setMedicateDependents(medicalDetails.getMedicateDependents());
	//		    addMedicalInformation = addMedicalInformation(isDetailsFound, sapId);
			    logs.info("Medical Details Updated SuccessFully for Employee { }" ,sapId);
		}catch (InternalServerException e) {
		logs.info("Error Occured While Updating Details --> { }", e.getMessage());
		  throw new InternalServerException("Error Occured While Updating Details" +e.getMessage());
		}
		return addMedicalInformation;
	}

	@Override
	public void deleteMedicalInformation(Long sapId) {
		try {
			medicalDetialsRepo.deleteById(sapId);
			logs.info("Medical Details Deleted SuccessFully for Employee {}" ,sapId);
		}catch (InternalServerException e) {
		  throw new InternalServerException("An Error Occured while deleting Information" +e.getMessage());
		}
	}
	
}
