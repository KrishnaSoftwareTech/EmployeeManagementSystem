package com.EmployeeManagmentSystem.Rest.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.NotAcceptable;
import com.EmployeeManagmentSystem.Rest.Exception.DataProcessingException;
import com.EmployeeManagmentSystem.Rest.Exception.SchemaProcessingException;
import com.EmployeeManagmentSystem.Rest.Model.AdharInformation;
import com.EmployeeManagmentSystem.Rest.Model.EducationDetails;
import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;
import com.EmployeeManagmentSystem.Rest.Model.EmpCompanyBranchDetails;
import com.EmployeeManagmentSystem.Rest.Model.EmpHRCompensation;
import com.EmployeeManagmentSystem.Rest.Model.EmpMedicalDetails;
import com.EmployeeManagmentSystem.Rest.Model.EmpPersonalDetails;
import com.EmployeeManagmentSystem.Rest.Model.Employee;
import com.EmployeeManagmentSystem.Rest.Model.EmployeeCentralizedSchemas;
import com.EmployeeManagmentSystem.Rest.Model.FamilyDetails;
import com.EmployeeManagmentSystem.Rest.Repository.AdharInformationRepository;
import com.EmployeeManagmentSystem.Rest.Repository.EmpBankDetailsRepository;
import com.EmployeeManagmentSystem.Rest.Repository.EmpCompanyBranchDetailsRepository;
import com.EmployeeManagmentSystem.Rest.Repository.EmpEducationDetailsRepository;
import com.EmployeeManagmentSystem.Rest.Repository.EmpFamilyDetailsRepository;
import com.EmployeeManagmentSystem.Rest.Repository.EmpMedicalDetailsRepository;
import com.EmployeeManagmentSystem.Rest.Repository.EmpPersonalDetailsRepository;
import com.EmployeeManagmentSystem.Rest.Repository.EmployeeCentralizedSchemasRepository;
import com.EmployeeManagmentSystem.Rest.Repository.EmployeeCompensationRepository;
import com.EmployeeManagmentSystem.Rest.Repository.EmployeeRepository;

/**
 * @author krishnakumar
 * @copyRight rights
 */
@Service
//@Component
public class EmployeeCentralizeSchemaUtility {
	///// We are using all the repostories that are needed to fetch the employee details 
	/* @  	 
	 *  @param employeeRepository 
	 * @param personalDetails
	 * @param familyDetails
	 * @param educationDetails
	 * @param adharInformation
	 * @param bankDetails
	 * @param medicalDetails
	 * @param medicalDependents
	 **/
   
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private EmpBankDetailsRepository bankDetails;
	@Autowired
	private EmpCompanyBranchDetailsRepository branchDetails;
	@Autowired
	private EmpMedicalDetailsRepository medicalDetails;
	@Autowired
	private EmpPersonalDetailsRepository personalDetails;
	@Autowired
	private EmpEducationDetailsRepository educationDetails;
	@Autowired
	private AdharInformationRepository adharInformation;
	@Autowired
	private EmpFamilyDetailsRepository familyDetails;
	@Autowired
	private EmployeeCompensationRepository compensationRepo;
	
	/// add to centrol repo
    @Autowired
	private EmployeeCentralizedSchemasRepository centralRepo;

	//@Autowired
	private EmployeeCentralizedSchemas schema;
	
	
	//Find 
	public List<Object> employeeCustomReponse(Long sapid) {
		List<Object> employeeObject=new ArrayList<>();
		EmployeeCentralizedSchemas schemasDetails = null;
		try {
		 Optional<Employee> employeeDetail = empRepo.findById(sapid);
		Optional<EmpMedicalDetails> medical = medicalDetails.findById(sapid);
		Optional<EmpBankDetails> bankDetail = bankDetails.findById(sapid);
		Optional<EmpCompanyBranchDetails> branchDetail = branchDetails.findById(sapid);
		Optional<EmpPersonalDetails> personalDetail = personalDetails.findById(sapid);
		Optional<EducationDetails> educationDetail = educationDetails.findById(sapid);
		Optional<AdharInformation> adharDetails = adharInformation.findById(sapid);
		Optional<FamilyDetails> familyDetail = familyDetails.findById(sapid);
		Optional<EmpHRCompensation> compensationDetails = compensationRepo.findById(sapid);
			// add all details into list
			employeeObject.add(employeeDetail);
			employeeObject.add(employeeDetail);
			employeeObject.add(medical);
			employeeObject.add(bankDetail);
			employeeObject.add(branchDetail);
			employeeObject.add(personalDetail);
			employeeObject.add(educationDetail);
			employeeObject.add(adharDetails);
			employeeObject.add(familyDetail);
			employeeObject.add(compensationDetails);
			//addInto DB 
			//important
			/*
			 * schemasDetails = addSchemasDetails(sapid, familyDetail, adharDetails,
			 * educationDetail, branchDetail, personalDetail, bankDetail, medical,
			 * employeeDetail, compensationDetails);
			 */
		}catch (DataProcessingException dataException) {
			dataException.printStackTrace();	
		}
		return employeeObject;
	}
	//optional
	private EmployeeCentralizedSchemas addSchemasDetails(Long sapid,Optional<FamilyDetails> familyDetail,Optional<AdharInformation> adharDetails,
			Optional<EducationDetails> educationDetail,Optional<EmpCompanyBranchDetails> branchDetail,Optional<EmpPersonalDetails> personalDetail,
			Optional<EmpBankDetails> bankDetail,Optional<EmpMedicalDetails> medical,Optional<Employee> employeeDetail,
			Optional<EmpHRCompensation> compensationDetails) {
		try {
			ArrayList<FamilyDetails> famD = new ArrayList<>();
			ArrayList<AdharInformation> adharD=new ArrayList<>();
			ArrayList<EducationDetails> EmpEd=new ArrayList<>();
			ArrayList<EmpCompanyBranchDetails> BranchD=new ArrayList<>();
			ArrayList<EmpPersonalDetails> personalD=new ArrayList<>();
			ArrayList<EmpBankDetails> bankD=new ArrayList<>();
			ArrayList<EmpMedicalDetails> medicalD=new  ArrayList<>();
		    ArrayList<Employee> emp=new ArrayList<>();
			ArrayList<EmpHRCompensation> compD=new ArrayList<>(); //famil  , comp , 
			if(adharDetails.isEmpty() && educationDetail.isEmpty() && branchDetail.isEmpty() && bankDetail.isEmpty()
					&& medical.isEmpty() && employeeDetail.isEmpty() && compensationDetails.isEmpty()) {
				//	famD.add(familyDetail.get());
					adharD.add(adharDetails.get());
					EmpEd.add(educationDetail.get());
					BranchD.add(branchDetail.get());
					personalD.add(personalDetail.get());
					bankD.add(bankDetail.get());
					medicalD.add(medical.get());
					emp.add(employeeDetail.get());
					compD.add(compensationDetails.get());
					 //
					schema.setSapid(sapid);
				//	schema.setFamilyDetails(famD);
					schema.setAdharInformation(adharD);
					schema.setBankDetails(bankD);
					schema.setBranchDetails(BranchD);
					schema.setMedicalDetails(medicalD);
					schema.setEmp(emp);
					schema.setEducationDetails(EmpEd);
					schema.setPersonalDetails(personalD);
					//schema.setCompensation
					centralRepo.save(schema);
			}
			else {
				throw new SchemaProcessingException("Missing Schema Details");
			}
		   
		}catch (SchemaProcessingException  dataExp) {
			throw new SchemaProcessingException("Exception on Adding schema to DB ");
		} finally {
		}
			return schema;
	}
	
	//// in  progress 
/*	private EmployeeCentralizedSchemas addSchemasDetails(Long sapid, FamilyDetails familyDetail, AdharInformation adharDetails,
			EducationDetails educationDetail, EmpCompanyBranchDetails branchDetail, EmpPersonalDetails personalDetail,
			EmpBankDetails bankDetail, EmpMedicalDetails medical, Employee employeeDetail,
			EmpHRCompensation compensationDetails) {
		
			try {
			ArrayList<FamilyDetails> famD = new ArrayList<>();
			famD.add(familyDetail);
			ArrayList<AdharInformation> adharD=new ArrayList<>();
			adharD.add(adharDetails);
			ArrayList<EducationDetails> EmpEd=new ArrayList<>();
			EmpEd.add(educationDetail);
			ArrayList<EmpCompanyBranchDetails> BranchD=new ArrayList<>();
			BranchD.add(branchDetail);
			ArrayList<EmpPersonalDetails> personalD=new ArrayList<>();
			personalD.add(personalDetail);
			ArrayList<EmpBankDetails> bankD=new ArrayList<>();
			bankD.add(bankDetail);
			ArrayList<EmpMedicalDetails> medicalD=new  ArrayList<>();
			medicalD.add(medical);
			ArrayList<Employee> emp=new ArrayList<>();
			emp.add(employeeDetail);
			ArrayList<EmpHRCompensation> compD=new ArrayList<>();
			compD.add(compensationDetails);
		    //
			schema.setSapid(sapid);
			schema.setFamilyDetails(famD);
			schema.setAdharInformation(adharD);
			schema.setBankDetails(bankD);
			schema.setBranchDetails(BranchD);
			schema.setMedicalDetails(medicalD);
			schema.setEmp(emp);
			schema.setEducationDetails(EmpEd);
			schema.setPersonalDetails(personalD);
			//schema.setCompensation
			
			centralRepo.save(schema);
		}catch (DataProcessingException | NotAcceptable dataExp) {
			throw new DataProcessingException("Exception on Adding schema to DB ");
		}
			return schema;
	}
	*/
}
