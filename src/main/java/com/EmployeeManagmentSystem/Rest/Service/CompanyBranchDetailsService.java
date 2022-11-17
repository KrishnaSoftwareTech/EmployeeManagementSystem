package com.EmployeeManagmentSystem.Rest.Service;

import java.util.Optional;

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
		Optional<EmpCompanyBranchDetails> branchDetails = null;
		boolean isEmployeePresent = util.checkEmployeeBySapId(sapid);
		if(!isEmployeePresent) {
			log.error("Employee Not Found For {}"+sapid);
			throw new ResourceNotFoundException("Employee Not Found " +sapid);
		}else {
			branchDetails = branchrepo.findById(sapid);
			boolean anyMatch = branchDetails.stream().anyMatch(value ->value.getSapid().equals(sapid));
			if(!anyMatch){
				log.error("Employee Branch Details Not Found for {}"+sapid);
				throw new ResourceNotFoundException(" Branch Not Available " + sapid);
			}
		 return branchDetails;
		}
	}

	@Override
	public EmpCompanyBranchDetails addBranchDetails(Long sapId, EmpCompanyBranchDetails branchDetails) {
		boolean isEmployeePresent = util.checkEmployeeBySapId(sapId);
		if (isEmployeePresent) {
			branchDetails.setSapid(sapId);
			log.info("Employees Branch Details Addedd " +branchDetails.toString());
			branchrepo.save(branchDetails);
		}
		else {
			log.error("Employee Not Found For {}"+sapId);
			throw new ResourceNotFoundException("Employee Not Found " +sapId);
		}
		return branchDetails;
	}
	
	@Override
	public EmpCompanyBranchDetails updateBranchDetails(Long sapId,EmpCompanyBranchDetails branchDetails) throws InterruptedException {
		 Optional<Employee> checkEmployee = util.checkEmployee(sapId);
		 try {
		if(checkEmployee != null) {
			Optional<EmpCompanyBranchDetails> branch= getBranchDetails(sapId);
			EmpCompanyBranchDetails empCompanyBranchDetails = branch.get();
			empCompanyBranchDetails.setBranchAddress(branchDetails.getBranchAddress());
			empCompanyBranchDetails.setBranchName(branchDetails.getBranchName());
			empCompanyBranchDetails.sethead_of_department_id(branchDetails.gethead_of_department_id());
			return empCompanyBranchDetails;
		}
		else {
			log.error("Employee Not Found For {}"+sapId);
			throw new ResourceNotFoundException("Employee Not Found - " + sapId);
		}
		 }catch (Exception e) {
		   throw new InterruptedException("Internal Server Excpetion");
		}
	}

	public void deleteBranchById(Long sapId) {
		boolean checkEmployeeBySapId = util.checkEmployeeBySapId(sapId);
		if(checkEmployeeBySapId) {
			log.warn("removing Branch Details for" +sapId);
			branchrepo.deleteById(sapId);
		}
		else {
			log.error("Employee Not Found For {}"+sapId);
			throw new ResourceNotFoundException("Unable to delete "+sapId);
		}
	}
}
