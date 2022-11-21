package com.EmployeeManagmentSystem.Rest.Service;

import java.lang.module.ResolutionException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Exception.InternalServerException;
import com.EmployeeManagmentSystem.Rest.Exception.ResourceNotFoundException;
import com.EmployeeManagmentSystem.Rest.Model.EducationDetails;
import com.EmployeeManagmentSystem.Rest.Repository.EmpEducationDetailsRepository;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.EducationDetailsInterface;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.GraduationDetailsInterface;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.IntermediateDetailsInterface;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.PrimarySchoolDetailsInterf;

/**
 * @author krishnakumar
 *
 */
@Service
public class EducationDetailsService implements EducationDetailsInterface {
	
	private static final Logger logs=LoggerFactory.getLogger(EducationDetailsService.class.getPackage().getName());
	
	@Autowired
	private EmpEducationDetailsRepository educationRepo;
	@Autowired
	private GraduationDetailsInterface graduationInfoService;
	@Autowired
	private IntermediateDetailsInterface intermediateInfoService;
	@Autowired
	private PrimarySchoolDetailsInterf school_InfoService;
	@Autowired
	private UtilityService util;

	@Override
	public Optional<EducationDetails> getEmployeeEducationInfo(Long sapId) throws InternalServerException {
		Optional<EducationDetails> getInfo = null;
		if (util.checkEmployeeBySapId(sapId)) {
			try {
			    getInfo = educationRepo.findById(sapId);
			    boolean present = getInfo.isPresent();
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
		Long empSapId = sapId;
		educationInfo.setSapId(empSapId);
		if(util.checkEmployeeBySapId(sapId)) {
			try {
				educationRepo.save(educationInfo);
			logs.info("Employee Education Details Added {} ", educationInfo);
			}catch (InternalServerException exception) {
				logs.error("An exception has occured while processing the Request , Unable to addEducatioin Details for{} " +sapId);
				throw new InternalServerException("An exception has occured while processing the Request , Unable to addEducatioin Details for " +sapId);
			}
		}else {
			logs.error("Employee Not Found {}",sapId);
			throw new ResourceNotFoundException("Employee Not Found");
		}
		return educationInfo;
	}
	@Override
	public EducationDetails updateEducationInfo(Long sapId, EducationDetails educationDetails) {
		if(util.checkEmployeeBySapId(sapId)) {
			try {
				EducationDetails employeeEducationInfo = educationRepo.findById(sapId)
						.orElseThrow(() -> new ResourceNotFoundException("Education Details NotFound for " +sapId));			
				//set
				employeeEducationInfo.setSapId(sapId);
				employeeEducationInfo.setGraduation(educationDetails.getGraduation());
				employeeEducationInfo.setIntermedite(educationDetails.getIntermedite());
				employeeEducationInfo.setSchool(educationDetails.getSchool());
				educationDetails.setSapId(sapId);
				educationRepo.save(educationDetails);
			}catch (InternalServerException internalError) {
				throw new InternalServerException("Unable to Add Education Info"+ sapId);
			}
		}
		else {
			logs.error("Employee Not Found {}",sapId);
			throw new ResourceNotFoundException("Employee Not Found "+sapId);
		}
		return educationDetails;
	}

	@Override
	public void deleteEducationInfo(Long sapId) {
//		if(!util.checkEmployeeBySapId(sapId)) {
//			logs.error("Employee Not Found {}",sapId);
//			throw new ResolutionException("Employee Not Found " + sapId);
//		}
		try {
		educationRepo.deleteById(sapId);
		}catch (InternalServerException exception) {
			throw new InternalServerException("Unable to Delete Education Information "+ sapId);
		}
	}

}
