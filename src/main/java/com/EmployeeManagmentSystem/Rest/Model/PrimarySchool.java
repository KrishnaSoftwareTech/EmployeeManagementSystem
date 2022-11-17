package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Embeddable
@Entity
public class PrimarySchool {

	@Id
	private Long School_Id;
	private String SchoolBoard;
	private String SchoolUniversityName;
	private String Country;
	private int percentage;
	@OneToOne(targetEntity=EducationDetails.class,  fetch=FetchType.EAGER)
	private EducationDetails sapID; 
	
	
	public PrimarySchool() {
		
	}
	/**
	 * @param schoolBoard
	 * @param schoolUniversityName
	 * @param country
	 * @param percentage
	 */
	public PrimarySchool(String schoolBoard, String schoolUniversityName, String country, int percentage) {
		super();
		SchoolBoard = schoolBoard;
		SchoolUniversityName = schoolUniversityName;
		Country = country;
		this.percentage = percentage;
	}


	public String getSchoolBoard() {
		return SchoolBoard;
	}
	public void setSchoolBoard(String schoolBoard) {
		SchoolBoard = schoolBoard;
	}
	public String getSchoolUniversityName() {
		return SchoolUniversityName;
	}
	public void setSchoolUniversityName(String schoolUniversityName) {
		SchoolUniversityName = schoolUniversityName;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
}
