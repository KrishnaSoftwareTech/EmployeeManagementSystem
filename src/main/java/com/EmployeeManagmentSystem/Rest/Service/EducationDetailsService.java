package com.EmployeeManagmentSystem.Rest.Service;

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

	/**@ValidationSteps 
	 * first add educationDetails -> as "sapId"="123243" , "graduation_id" =null,"Intermediate"=null ,"School_Id"=null ; 
	 * Second add Graduation_Details ,Intermediate_Details, School_details 
	 * Third update educationDetails as -> sap + along with graduation id , intermediate id , school id
	 **/
	@Override
	public EducationDetails addEmployeeEducationinfo(Long sapId, EducationDetails educationInfo) {
		Long empSapId = sapId;
		EducationDetails empEducationInfo = educationInfo;
		empEducationInfo.setSapId(empSapId);
		if(util.checkEmployeeBySapId(sapId)) {
			try {
			//Add school , inter ,and graducaiton details 
			 addSapAsNull(educationInfo);
			//Add Education Info 
				 addEducationInfoAsNull(empSapId, educationInfo);
		  //Update Education DEtails
			 updateEducationInfo(sapId, empEducationInfo);
		//EducationDetails addEducationInfo = educationRepo.save(educationInfo);
			logs.info("Employee Education Details Added {} ", educationInfo);
			}catch (InternalServerException exception) {
				logs.error("An exception has occured while processing the Request , Unable to addEducatioin Details for{} " +sapId);
				throw new InternalServerException("An exception has occured while processing the Request , Unable to addEducatioin Details for " +sapId);
			}
			
		}else {
			logs.error("Employee Not Found {}",sapId);
			throw new ResourceNotFoundException("Employee Not Found");
		}
		return null;
	}

	private void addSapAsNull(EducationDetails educationInfo) {
		educationInfo.setSapId(null);
		Long school_Id = educationInfo.getSchool().getSchool_Id();
//		Set<PrimarySchoolDetails> scl=new HashSet<PrimarySchoolDetails>();
//		scl.addAll((Collection<? extends PrimarySchoolDetails>) educationInfo.getSchool());
		school_InfoService.addSchoolInformation(educationInfo.getSchool());
		intermediateInfoService.addIntermediateInfo(educationInfo.getIntermedite());
		graduationInfoService.addGraduationInfo(educationInfo.getGraduation());
	}

	private void addEducationInfoAsNull(Long sapId, EducationDetails educationInfo) {
		educationInfo.setSapId(sapId);
		educationInfo.setGraduation(null);
		educationInfo.setIntermedite(null);
		educationInfo.setSchool(null);
		educationRepo.save(educationInfo);
	}

	@Override
	public void updateEducationInfo(Long sapId, EducationDetails educationDetails) {
		if(util.checkEmployeeBySapId(sapId)) {
			try {
				EducationDetails employeeEducationInfo = educationRepo.findById(sapId)
						.orElseThrow(() -> new ResourceNotFoundException("Education Details NotFound for " +sapId));			
				//set
				employeeEducationInfo.setGraduation(educationDetails.getGraduation());
				employeeEducationInfo.setIntermedite(educationDetails.getIntermedite());
				employeeEducationInfo.setSchool(educationDetails.getSchool());
			}catch (InternalServerException internalError) {
				throw new InternalServerException("Unable to Add Education Info2"+ sapId);
			}
		}
		else {
			logs.error("Employee Not Found {}",sapId);
			throw new ResourceNotFoundException("Employee Not Found "+sapId);
		}
	}

	@Override
	public void deleteEducationInfo(Long sapId) {
	}

}
