package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Embeddable
@Entity
public class PrimarySchool {

	@Id
//	@GeneratedValue
	private Long School_Id;
	private String SchoolBoard;
	private String SchoolUniversityName;
	private String Country;
	private int percentage;
	@OneToOne(targetEntity=EducationDetails.class,  fetch=FetchType.EAGER)
	@JsonBackReference 
	private EducationDetails sapID; 
	
//    "school": {
//    "percentage": 72,
//    "schoolBoard": "SSC-AP",
//    "schoolUniversityName": "Sri Ushodaya E/M School",
//    "country": "India"
//}
	
	/**
	 * @param school_Id
	 * @param schoolBoard
	 * @param schoolUniversityName
	 * @param country
	 * @param percentage
	 * @param sapID
	 */
	public PrimarySchool(Long school_Id, String schoolBoard, String schoolUniversityName, String country,
			int percentage, EducationDetails sapID) {
		super();
		School_Id = school_Id;
		SchoolBoard = schoolBoard;
		SchoolUniversityName = schoolUniversityName;
		Country = country;
		this.percentage = percentage;
		this.sapID = sapID;
	}
	public Long getSchool_Id() {
		return School_Id;
	}
	public void setSchool_Id(Long school_Id) {
		School_Id = school_Id;
	}
	public EducationDetails getSapID() {
		return sapID;
	}
	public void setSapID(EducationDetails sapID) {
		this.sapID = sapID;
	}
	public PrimarySchool() {
		
	}
	/**
	 * @param schoolBoard
	 * @param schoolUniversityName
	 * @param country
	 * @param percentage
	 */
//	public PrimarySchool(String schoolBoard, String schoolUniversityName, String country, int percentage) {
//		super();
//		SchoolBoard = schoolBoard;
//		SchoolUniversityName = schoolUniversityName;
//		Country = country;
//		this.percentage = percentage;
//	}


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
	@Override
	public String toString() {
		return "PrimarySchool [School_Id=" + School_Id + ", SchoolBoard=" + SchoolBoard + ", SchoolUniversityName="
				+ SchoolUniversityName + ", Country=" + Country + ", percentage=" + percentage + ", sapID=" + sapID
				+ "]";
	}
}
