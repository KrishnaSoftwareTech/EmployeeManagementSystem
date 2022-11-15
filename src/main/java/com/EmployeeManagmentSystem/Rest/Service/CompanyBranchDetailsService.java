package com.EmployeeManagmentSystem.Rest.Service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Exception.ResourceNotFoundException;
import com.EmployeeManagmentSystem.Rest.Model.EmpCompanyBranchDetails;
import com.EmployeeManagmentSystem.Rest.Model.Employee;
import com.EmployeeManagmentSystem.Rest.Repository.EmpCompanyBranchDetailsRepository;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.CompanyBranchInterface;

/**
 * @author krishnakumar
 *
 */
@Service
public class CompanyBranchDetailsService implements CompanyBranchInterface{

	private static final Logger log = LoggerFactory.getLogger(CompanyBranchDetailsService.class);
	
	@Autowired
	private EmpCompanyBranchDetailsRepository branchrepo;
	
	@Autowired
	private UtilityService util;
	
	@Override
	public Optional<EmpCompanyBranchDetails> getBranchDetails(Long sapid) {
		boolean isEmployeePresent = util.checkEmployeeBySapId(sapid);
		if(!isEmployeePresent) {
			log.error("Employee Not Found For {}"+sapid);
			throw new ResourceNotFoundException("Employee Not Found " +sapid);
		}else {
			Optional<EmpCompanyBranchDetails> branchDetails = branchrepo.findById(sapid);
			if(!branchDetails.isPresent()){
				log.error("Employee Branch Details Not Found for {}"+sapid);
				throw new ResourceNotFoundException(" Branch Not Available " + sapid);
			}
		 return branchDetails;
		}
	}

}
