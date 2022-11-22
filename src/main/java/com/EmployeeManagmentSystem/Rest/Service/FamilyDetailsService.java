package com.EmployeeManagmentSystem.Rest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Model.Employee;
import com.EmployeeManagmentSystem.Rest.Model.FamilyDetails;
import com.EmployeeManagmentSystem.Rest.Repository.EmpFamilyDetailsRepository;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.FamilyDetailsInterface;

/**
 * @author krishnakumar
 *
 */
@Service
public class FamilyDetailsService implements FamilyDetailsInterface{
	
	@Autowired
	private EmpFamilyDetailsRepository familyInfoRepo;
	
//	@Autowired
//	private Employee employee;

	@Override
	public FamilyDetails getFamilyInfo(Long sapId) {
	//	familyInfoRepo.getBySapId(sapId);
		return null;
	}

	@Override
	public FamilyDetails addFamilyInfo(FamilyDetails familyInfo, Long sapId) {
		
	//	employee.setId(sapId);
		//familyInfo.setEmployee(employee.setId(sapId));
		familyInfoRepo.save(familyInfo);
		return null;
	}

}
