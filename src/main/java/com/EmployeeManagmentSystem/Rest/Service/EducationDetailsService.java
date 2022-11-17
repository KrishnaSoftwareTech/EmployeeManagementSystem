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
	
	private static final Logger logs=LoggerFactory.getLogger(EducationDetailsService.class.getPackage().getName());
	
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

	/**@ValidationSteps 
	 * first add educationDetails -> as "sapId"="123243" , "graduation_id" =null,"Intermediate"=null ,"School_Id"=null ; 
	 * Second add Graduation_Details ,Intermediate_Details, School_details 
	 * Third update educationDetails as -> sap + along with graduation id , intermediate id , school id
	 **/
	@Override
	public EducationDetails addEmployeeEducationinfo(Long sapId, EducationDetails educationInfo) {
		if(util.checkEmployeeBySapId(sapId)) {
			try {
			educationInfo.setSapId(sapId);
			EducationDetails addEducationInfo = educationRepo.save(educationInfo);
			logs.info("Employee Education Details Added {} ", educationInfo);
			}catch (InternalServerException exception) {
				String message = exception.getMessage();
				logs.error("An exception has occured while processing the Request , Unable to addEducatioin Details for{} " +sapId);
				throw new InternalServerException("An exception has occured while processing the Request , Unable to addEducatioin Details for " +sapId);
			}
			
		}else {
			logs.error("Employee Not Found {}",sapId);
			throw new ResourceNotFoundException("Employee Not Found");
		}
		return null;
	}

	@Override
	public void updateEducationInfo(Long sapId, EducationDetails educationDetails) {
	}

	@Override
	public void deleteEducationInfo(Long sapId) {
	}

}
