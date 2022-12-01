package com.EmployeeManagmentSystem.Rest.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Exception.InternalServerException;
import com.EmployeeManagmentSystem.Rest.Exception.ResourceNotFoundException;
import com.EmployeeManagmentSystem.Rest.Model.EmpHRCompensation;
import com.EmployeeManagmentSystem.Rest.Repository.EmployeeCompensationRepository;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.HrCompensationServiceInterface;

/**
 * @author krishnakumar
 *
 */
@Service
public class HrCompensationService implements HrCompensationServiceInterface {

	@Autowired
	private EmployeeCompensationRepository compensationRepo;
	@Autowired
	private UtilityService utility;
	
	private static final Logger logger=LoggerFactory.getLogger(HrCompensationService.class);
	
	@Override
	public EmpHRCompensation getCompensationInfo(Long sapid) {
		EmpHRCompensation CompensationDetails = compensationRepo
							.findById(sapid)
							.orElseThrow(()->new ResourceNotFoundException("Employee With SapId NotFound " +sapid));
		logger.info("Employee --> {}" ,sapid);
		return CompensationDetails;
	}
	@Override
	public EmpHRCompensation addCompensationDetails(Long sapid, EmpHRCompensation compensationinfo) {
		EmpHRCompensation addCompensation = null;
		try {
			if(utility.checkEmployeeBySapId(sapid)) {
			  compensationinfo.setSapId(sapid);
			  addCompensation = compensationRepo.save(compensationinfo);
			  logger.info(" Employee Compensation Added Successfully ");}
			  else {
				  throw new ResourceNotFoundException("Employee Not Found For "+sapid);
			  }
			}catch (InternalServerException exp) {
				logger.error(exp.getLocalizedMessage());
			throw new InternalServerException(exp.getLocalizedMessage());
		}
		return addCompensation;
	}
	
	@Override
	public EmpHRCompensation updateCompensationDetials(Long sapid, EmpHRCompensation compensationinfo) {
		EmpHRCompensation updateCompensation;
		try {
			if(utility.checkEmployeeBySapId(sapid)) {
				//get
				
				//set
				//update 
				 updateCompensation = compensationRepo.save(null);
			}
			else {
				throw new ResourceNotFoundException("Employee NotFound For" +sapid);
			}
		}catch (InternalServerException e) {
		 throw new InternalServerException(e.getLocalizedMessage());
		}
		return updateCompensation;
	}
	
	
}
