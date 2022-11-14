//package com.EmployeeManagmentSystem.Rest.Model;
//
//import javax.persistence.Embeddable;
//import javax.persistence.Embedded;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
///**
// * @author krishnakumar
// *
// */
//@Entity
//@Embeddable
//public class EmployeeInfo {
//	
//	@Id
//	//@GeneratedValue(strategy = GenerationType.AUTO)
//	Long id;
//
//	@Embedded
//	EmpPersonalDetails personalDetails;
//	@Embedded
//	EmpEducationDetails educationDetails;
//	@Embedded
//	EmpBankDetails bankDetails;
//	@Embedded
//	EmpMedicalDetails medicalDetails;
//	@Embedded
//	EmpHRCompensation hrCompensationDetails;
//	@Embedded
//	EmpCompanyBranchDetaila companyDetails;
//	/**
//	 * @param id
//	 * @param personalDetails
//	 */
//	public EmployeeInfo(Long id, EmpPersonalDetails personalDetails) {
//		super();
//		this.id = id;
//		this.personalDetails = personalDetails;
//	}
//	/**
//	 * @param id
//	 * @param companyDetails
//	 */
//	public EmployeeInfo(Long id, EmpCompanyBranchDetaila companyDetails) {
//		super();
//		this.id = id;
//		this.companyDetails = companyDetails;
//	}
//	/**
//	 * @param id
//	 * @param educationDetails
//	 */
//	public EmployeeInfo(Long id, EmpEducationDetails educationDetails) {
//		super();
//		this.id = id;
//		this.educationDetails = educationDetails;
//	}
//	/**
//	 * @param id
//	 * @param hrCompensationDetails
//	 */
//	public EmployeeInfo(Long id, EmpHRCompensation hrCompensationDetails) {
//		super();
//		this.id = id;
//		this.hrCompensationDetails = hrCompensationDetails;
//	}
//	/**
//	 * @param id
//	 * @param medicalDetails
//	 */
//	public EmployeeInfo(Long id, EmpMedicalDetails medicalDetails) {
//		super();
//		this.id = id;
//		this.medicalDetails = medicalDetails;
//	}
//	/**
//	 * @param id
//	 * @param bankDetails
//	 */
//	public EmployeeInfo(Long id, EmpBankDetails bankDetails) {
//		super();
//		this.id = id;
//		this.bankDetails = bankDetails;
//	}
//	/**
//	 * @param id
//	 * @param personalDetails
//	 * @param educationDetails
//	 * @param bankDetails
//	 * @param medicalDetails
//	 * @param hrCompensationDetails
//	 * @param companyDetails
//	 */
//	public EmployeeInfo(Long id, EmpPersonalDetails personalDetails, EmpEducationDetails educationDetails,
//			EmpBankDetails bankDetails, EmpMedicalDetails medicalDetails, EmpHRCompensation hrCompensationDetails,
//			EmpCompanyBranchDetaila companyDetails) {
//		super();
//		this.id = id;
//		this.personalDetails = personalDetails;
//		this.educationDetails = educationDetails;
//		this.bankDetails = bankDetails;
//		this.medicalDetails = medicalDetails;
//		this.hrCompensationDetails = hrCompensationDetails;
//		this.companyDetails = companyDetails;
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public EmpPersonalDetails getPersonalDetails() {
//		return personalDetails;
//	}
//	public void setPersonalDetails(EmpPersonalDetails personalDetails) {
//		this.personalDetails = personalDetails;
//	}
//	public EmpEducationDetails getEducationDetails() {
//		return educationDetails;
//	}
//	public void setEducationDetails(EmpEducationDetails educationDetails) {
//		this.educationDetails = educationDetails;
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
//	public EmpHRCompensation getHrCompensationDetails() {
//		return hrCompensationDetails;
//	}
//	public void setHrCompensationDetails(EmpHRCompensation hrCompensationDetails) {
//		this.hrCompensationDetails = hrCompensationDetails;
//	}
//	public EmpCompanyBranchDetaila getCompanyDetails() {
//		return companyDetails;
//	}
//	public void setCompanyDetails(EmpCompanyBranchDetaila companyDetails) {
//		this.companyDetails = companyDetails;
//	}
//	@Override
//	public String toString() {
//		return "EmployeeInfo [id=" + id + ", personalDetails=" + personalDetails + ", educationDetails="
//				+ educationDetails + ", bankDetails=" + bankDetails + ", medicalDetails=" + medicalDetails
//				+ ", hrCompensationDetails=" + hrCompensationDetails + ", companyDetails=" + companyDetails + "]";
//	}
//
//	
//	
//}
