package com.EmployeeManagmentSystem.Rest.Model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
@Embeddable
@Table
@Entity
public class EmpPersonalDetails {

	@Override
	public String toString() {
		return "EmpPersonalDetails [sapId=" + sapId + ", firstName=" + firstName + ", LastName=" + LastName
				+ ", MiddleName=" + MiddleName + ", MaritualStatus=" + MaritualStatus + ", Gender=" + Gender
				+ ", Nationality=" + Nationality + ", CountryOfBirth=" + CountryOfBirth + ", StateOfBirth="
				+ StateOfBirth + ", Citizen=" + Citizen + ", DateOfBirth=" + DateOfBirth + ", FamilyDetails="
				+ FamilyDetails + "]";
	}
	@Id
	private Long sapId;
	private String firstName;
	private String LastName;
	private String MiddleName;
	private String MaritualStatus;
	private String Gender;
	private String Nationality;
	private String CountryOfBirth;
	private String StateOfBirth;
	private String Citizen;
	private Date DateOfBirth;
	@JsonManagedReference
	@OneToMany(targetEntity=FamilyDetails.class, fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonProperty("FamilyDetails")
	private List<FamilyDetails> FamilyDetails;
	/**
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * @param maritualStatus
	 * @param gender
	 * @param nationality
	 * @param countryOfBirth
	 * @param stateOfBirth
	 * @param citizen
	 * @param dateOfBirth
	 * @param familyDetails
	 */
	public EmpPersonalDetails(String firstName, String lastName, String middleName, String maritualStatus,
			String gender, String nationality, String countryOfBirth, String stateOfBirth, String citizen,
			Date dateOfBirth, List<com.EmployeeManagmentSystem.Rest.Model.FamilyDetails> familyDetails) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		MiddleName = middleName;
		MaritualStatus = maritualStatus;
		Gender = gender;
		Nationality = nationality;
		CountryOfBirth = countryOfBirth;
		StateOfBirth = stateOfBirth;
		Citizen = citizen;
		DateOfBirth = dateOfBirth;
//		FamilyDetails = familyDetails;
	}
	/**
	 * 
	 */
	public EmpPersonalDetails() {
		super();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getMaritualStatus() {
		return MaritualStatus;
	}
	public void setMaritualStatus(String maritualStatus) {
		MaritualStatus = maritualStatus;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public String getCountryOfBirth() {
		return CountryOfBirth;
	}
	public void setCountryOfBirth(String countryOfBirth) {
		CountryOfBirth = countryOfBirth;
	}
	public String getStateOfBirth() {
		return StateOfBirth;
	}
	public void setStateOfBirth(String stateOfBirth) {
		StateOfBirth = stateOfBirth;
	}
	public String getCitizen() {
		return Citizen;
	}
	public void setCitizen(String citizen) {
		Citizen = citizen;
	}
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	@JsonIgnore
	public List<FamilyDetails> getFamilyDetails() {
		return FamilyDetails;
	}
	public Long getSapId() {
		return sapId;
	}
	public void setSapId(Long sapId) {
		this.sapId = sapId;
	}
	//@JsonIgnore
	public void setFamilyDetails(List<FamilyDetails> familyDetails) {
		FamilyDetails = familyDetails;
	}
}
