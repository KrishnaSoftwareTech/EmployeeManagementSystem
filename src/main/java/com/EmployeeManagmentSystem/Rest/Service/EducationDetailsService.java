package com.EmployeeManagmentSystem.Rest.Service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Exception.InternalServerException;
import com.EmployeeManagmentSystem.Rest.Exception.ResourceNotFoundException;
import com.EmployeeManagmentSystem.Rest.Model.EducationDetails;
import com.EmployeeManagmentSystem.Rest.Repository.EmpEducationDetailsRepository;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.EducationDetailsInterface;

/**
 * @author krishnakumar
 *
 */
@Service
public class EducationDetailsService implements EducationDetailsInterface {
	
	private static final Logger logs=LoggerFactory.getLogger(EducationDetailsService.class);
	
	@Autowired
	private EmpEducationDetailsRepository educationRepo;
	
	@Autowired
	private UtilityService util;

	@Override
	public Optional<EducationDetails> getEmployeeEducationInfo(Long sapId) throws InternalServerException {
		Optional<EducationDetails> getInfo = null;
		if (util.checkEmployeeBySapId(sapId)) {
			try {
			    getInfo = educationRepo.findById(sapId);
			    boolean present = getInfo.isPresent();
			  //  getInfo.ifPresentOrElse(null, null);
			    if(!present) {
			    	logs.error("Education DEtails Not Found For Employee : {} "+sapId);
			    	throw new ResourceNotFoundException("Education Details Not Present "+sapId);
			    }
			}catch (InternalServerException error) {
				logs.error("Internal Server Exception Unable to Get Employee Information for {} " + sapId);
			    throw new InternalServerException("Internal Server Exception, Unable to Get Education Details");
			}
		}
		else {
			logs.error("Employee Not Found {}" +sapId);
			throw new ResourceNotFoundException("Employee  N0T Found"+sapId);
		}
		return getInfo;
	}

	@Override
	public EducationDetails addEmployeeEducationinfo(Long sapId, EducationDetails educationInfo) {
		return null;
	}

	@Override
	public void updateEducationInfo(Long sapId, EducationDetails educationDetails) {
	}

	@Override
	public void deleteEducationInfo(Long sapId) {
	}

}
