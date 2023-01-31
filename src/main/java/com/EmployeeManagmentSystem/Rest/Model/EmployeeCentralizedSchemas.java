package com.EmployeeManagmentSystem.Rest.Model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author krishnakumar
 *
 */
@Entity
@Embeddable
public class EmployeeCentralizedSchemas {
	@Id
	@Column(name="sapid")
	private Long sapid;
	private ArrayList<Employee> emp;
	private ArrayList<EmpPersonalDetails> personalDetails;
	private ArrayList<FamilyDetails> familyDetails;
	private ArrayList<EducationDetails> educationDetails;
	private ArrayList<AdharInformation> adharInformation;
	private ArrayList<EmpBankDetails> bankDetails;
	private ArrayList<EmpMedicalDetails>  medicalDetails;
	private ArrayList<EmpCompanyBranchDetails> branchDetails;
	private ArrayList<EmpHRCompensation> compensation;
	
/**
	 * @param sapid
	 * @param emp
	 * @param personalDetails
	 * @param familyDetails
	 * @param educationDetails
	 * @param adharInformation
	 * @param bankDetails
	 * @param medicalDetails
	 * @param compensation
	 * @param branchDetails
	 */
	public EmployeeCentralizedSchemas(Long sapid, ArrayList<Employee> emp, ArrayList<EmpPersonalDetails> personalDetails,
			ArrayList<FamilyDetails> familyDetails, ArrayList<EducationDetails> educationDetails,
			ArrayList<AdharInformation> adharInformation, ArrayList<EmpBankDetails> bankDetails,
			ArrayList<EmpMedicalDetails> medicalDetails, ArrayList<EmpHRCompensation> compensation,
			ArrayList<EmpCompanyBranchDetails> branchDetails) {
		super();
		this.sapid = sapid;
		this.emp = emp;
		this.personalDetails = personalDetails;
		this.familyDetails = familyDetails;
		this.educationDetails = educationDetails;
		this.adharInformation = adharInformation;
		this.bankDetails = bankDetails;
		this.medicalDetails = medicalDetails;
//		this.compensation = compensation;
		this.branchDetails = branchDetails;
	}

public Long getSapid() {
		return sapid;
	}

	public void setSapid(Long sapId) {
		this.sapid = sapId;
	}

	public ArrayList<Employee> getEmp() {
		return emp;
	}

	public void setEmp(ArrayList<Employee> emp) {
		this.emp = emp;
	}

	public ArrayList<EmpPersonalDetails> getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(ArrayList<EmpPersonalDetails> personalDetails) {
		this.personalDetails = personalDetails;
	}

	public ArrayList<FamilyDetails> getFamilyDetails() {
		return familyDetails;
	}

	public void setFamilyDetails(ArrayList<FamilyDetails> familyDetails) {
		this.familyDetails = familyDetails;
	}

	public ArrayList<EducationDetails> getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(ArrayList<EducationDetails> educationDetails) {
		this.educationDetails = educationDetails;
	}

	public ArrayList<AdharInformation> getAdharInformation() {
		return adharInformation;
	}

	public void setAdharInformation(ArrayList<AdharInformation> adharInformation) {
		this.adharInformation = adharInformation;
	}

	public ArrayList<EmpBankDetails> getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(ArrayList<EmpBankDetails> bankDetails) {
		this.bankDetails = bankDetails;
	}

	public ArrayList<EmpMedicalDetails> getMedicalDetails() {
		return medicalDetails;
	}

	public void setMedicalDetails(ArrayList<EmpMedicalDetails> medicalDetails) {
		this.medicalDetails = medicalDetails;
	}

//	public ArrayList<EmpHRCompensation> getCompensation() {
//		return compensation;
//	}
//
//	public void setCompensation(ArrayList<EmpHRCompensation> compensation) {
//		this.compensation = compensation;
//	}

	public ArrayList<EmpCompanyBranchDetails> getBranchDetails() {
		return branchDetails;
	}

	public void setBranchDetails(ArrayList<EmpCompanyBranchDetails> branchDetails) {
		this.branchDetails = branchDetails;
	}

@Override
	public String toString() {
		return "EmployeeCentralizedSchemas [sapid=" + sapid + ", emp=" + emp + ", personalDetails=" + personalDetails
				+ ", familyDetails=" + familyDetails + ", educationDetails=" + educationDetails + ", adharInformation="
				+ adharInformation + ", bankDetails=" + bankDetails + ", medicalDetails=" + medicalDetails
				 + ", branchDetails=" + branchDetails + "]";
	}
/////////////////////////
//	@Embedded
//	private Employee emp;
//	@Embedded
//	private EmpPersonalDetails personalDetails;@Embedded
//	private FamilyDetails familyDetails;@Embedded
//	private EducationDetails educationDetails;@Embedded
//	private AdharInformation adharInformation;@Embedded
//	private EmpBankDetails bankDetails;@Embedded
//	private EmpMedicalDetails  medicalDetails;@Embedded
//	private EmpHRCompensation compensation;@Embedded
//	private MedicalDependents medicalDependents;@Embedded
//	private EmpCompanyBranchDetails branchDetails;
//	public EmpCompanyBranchDetails getBranchDetails() {
//		return branchDetails;
//	}
//	public void setBranchDetails(EmpCompanyBranchDetails branchDetails) {
//		this.branchDetails = branchDetails;
//	}
//	public Long getSapId() {
//		return sapid;
//	}
//	public EmpHRCompensation getCompensation() {
//		return compensation;
//	}
//	public void setCompensation(EmpHRCompensation compensation) {
//		this.compensation = compensation;
//	}
//	public void setSapId(Long sapid) {
//		this.sapid = sapid;
//	}
//	public Employee getEmp() {
//		return emp;
//	}
//	public void setEmp(Employee emp) {
//		this.emp = emp;
//	}
//	public EmpPersonalDetails getPersonalDetails() {
//		return personalDetails;
//	}
//	public void setPersonalDetails(EmpPersonalDetails personalDetails) {
//		this.personalDetails = personalDetails;
//	}
//	public FamilyDetails getFamilyDetails() {
//		return familyDetails;
//	}
//	public void setFamilyDetails(FamilyDetails familyDetails) {
//		this.familyDetails = familyDetails;
//	}
//	public EducationDetails getEducationDetails() {
//		return educationDetails;
//	}
//	public void setEducationDetails(EducationDetails educationDetails) {
//		this.educationDetails = educationDetails;
//	}
//	public AdharInformation getAdharInformation() {
//		return adharInformation;
//	}
//	public void setAdharInformation(AdharInformation adharInformation) {
//		this.adharInformation = adharInformation;
//	}
//	public EmpBankDetails getBankDetails() {
//		return bankDetails;
//	}
//	public void setBankDetails(EmpBankDetails bankDetails) {
//		this.bankDetails = bankDetails;
//	}
//	public EmpMedicalDetails getMedicalDetails() {
//		return medicalDetails;
//	}
//	public void setMedicalDetails(EmpMedicalDetails medicalDetails) {
//		this.medicalDetails = medicalDetails;
//	}
//	public MedicalDependents getMedicalDependents() {
//		return medicalDependents;
//	}
//	public void setMedicalDependents(MedicalDependents medicalDependents) {
//		this.medicalDependents = medicalDependents;
//	}
//
//	/**
//	 * @param sapId
//	 * @param emp
//	 * @param personalDetails
//	 * @param familyDetails
//	 * @param educationDetails
//	 * @param adharInformation
//	 * @param bankDetails
//	 * @param medicalDetails
//	 * @param medicalDependents
//	 * @param branchDetails
//	 */
//	public EmployeeCentralizedSchemas(Long sapid, Employee emp, EmpPersonalDetails personalDetails,
//			FamilyDetails familyDetails, EducationDetails educationDetails, AdharInformation adharInformation,
//			EmpBankDetails bankDetails, EmpMedicalDetails medicalDetails, MedicalDependents medicalDependents,
//			EmpCompanyBranchDetails branchDetails,EmpHRCompensation compensation) {
//		super();
//		this.sapid = sapid;
//		this.emp = emp;
//		this.personalDetails = personalDetails;
//		this.familyDetails = familyDetails;
//		this.educationDetails = educationDetails;
//		this.adharInformation = adharInformation;
//		this.bankDetails = bankDetails;
//		this.medicalDetails = medicalDetails;
//		this.compensation=compensation;
//	//	this.medicalDependents = medicalDependents;
//		this.branchDetails = branchDetails;
//	}
//	public EmployeeCentralizedSchemas() {
//		super();
//	}
//	@Override
//	public String toString() {
//		return "EmployeeCentralizedSchemas [sapId=" + sapid + ", emp=" + emp + ", personalDetails=" + personalDetails
//				+ ", familyDetails=" + familyDetails + ", educationDetails=" + educationDetails + ", adharInformation="
//				+ adharInformation + ", bankDetails=" + bankDetails + ", medicalDetails=" + medicalDetails
//				+ ", compensation=" + compensation + ", branchDetails=" + branchDetails + "]";
//	}


}
// JavaMicrosersvices 
