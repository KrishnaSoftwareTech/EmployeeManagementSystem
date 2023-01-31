package com.EmployeeManagmentSystem.Rest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeManagmentSystem.Rest.Model.EmployeeCentralizedSchemas;
import com.EmployeeManagmentSystem.Rest.Repository.EmployeeCentralizedSchemasRepository;
import com.EmployeeManagmentSystem.Rest.ServiceInterface.EmployeeCentralizedSchemaServiceInterface;

/**
 * @author krishnakumar
 *
 */
@Service
public class EmployeeCentralizedSchemaService implements EmployeeCentralizedSchemaServiceInterface {

	@Autowired
	private EmployeeCentralizeSchemaUtility CentralUtility;
	
//	@Autowired
//	private EmployeeCentralizedSchemasRepository centralRepo;
	
	@Override
	public List<Object> getAllSchema(Long sapid) {
		////
		/* get all details of employees  like bank details , education details, perosnal details  ..... Etc and store in centrolized repository 
		 *  and pass to getApi of centrolized api
		 */
		List<Object> employeeCustomReponse = CentralUtility.employeeCustomReponse(sapid);
	//	addSchemaResponse(employeeCustomReponse);
	    return employeeCustomReponse;
	}


//	private void addSchemaResponse(EmployeeCentralizedSchemas employeeCustomReponse) {
		
//		centralRepo.save(null);
//	}
//			Optional[com.EmployeeManagmentSystem.Rest.Model.Employee@17da555d]
//			Optional[com.EmployeeManagmentSystem.Rest.Model.EmpMedicalDetails@77ffb403]
//			Optional[EmpBankDetails [SapId=14898912, BankAccountNumber=9102810231930, BankName=my bank, BankBranch=-AP, BankBranchAddress=vijag-2ndCross Road city]]
//			Optional[com.EmployeeManagmentSystem.Rest.Model.EmpCompanyBranchDetails@23c9d71b]
//			Optional.empty
//			Optional[com.EmployeeManagmentSystem.Rest.Model.EducationDetails@26151c6b]
//			Optional[AdharInformation [sapid=14898912, name=krishna kumar Nare, phoneNumber=8317594075, AdharNumber=540678261156, Gender=null]]
//			Optional.empty
}
