package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author krishnakumar
 *
 */
@Entity  
@Embeddable
public class Intermediate {

	@Id
//	@GeneratedValue
	private Long CollegeId;
	private String InterBoard;
	private String InterUniversityName;
	private String Country;
	private int InterPercentage;
	@OneToOne(targetEntity=EducationDetails.class,  fetch=FetchType.EAGER)
	@JsonBackReference
	private EducationDetails sapID; 
//	/**
//	 * @param interBoard
//	 * @param interUniversityName
//	 * @param country
//	 * @param interPercentage
//	 */
//	public Intermediate(String interBoard, String interUniversityName, String country, int interPercentage) {
//		super();
//		InterBoard = interBoard;
//		InterUniversityName = interUniversityName;
//		Country = country;
//		InterPercentage = interPercentage;
//	}
//	"intermedite": {
//  "interBoard": "IE-AP",
//  "interUniversityName": "Sri Vivekananda Junior College",
//  "interPercentage": 84,
//  "country": "India"
//},
	public Intermediate() {
		
	}

	public String getInterBoard() {
		return InterBoard;
	}

	public void setInterBoard(String interBoard) {
		InterBoard = interBoard;
	}

	/**
	 * @param collegeId
	 * @param interBoard
	 * @param interUniversityName
	 * @param country
	 * @param interPercentage
	 * @param sapID
	 */
	public Intermediate(Long collegeId, String interBoard, String interUniversityName, String country,
			int interPercentage, EducationDetails sapID) {
		super();
		CollegeId = collegeId;
		InterBoard = interBoard;
		InterUniversityName = interUniversityName;
		Country = country;
		InterPercentage = interPercentage;
		this.sapID = sapID;
	}

	public Long getCollegeId() {
		return CollegeId;
	}

	public void setCollegeId(Long collegeId) {
		CollegeId = collegeId;
	}

	public EducationDetails getSapID() {
		return sapID;
	}

	public void setSapID(EducationDetails sapID) {
		this.sapID = sapID;
	}

	public String getInterUniversityName() {
		return InterUniversityName;
	}

	public void setInterUniversityName(String interUniversityName) {
		InterUniversityName = interUniversityName;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public int getInterPercentage() {
		return InterPercentage;
	}

	public void setInterPercentage(int interPercentage) {
		InterPercentage = interPercentage;
	}

	@Override
	public String toString() {
		return "Intermediate [CollegeId=" + CollegeId + ", InterBoard=" + InterBoard + ", InterUniversityName="
				+ InterUniversityName + ", Country=" + Country + ", InterPercentage=" + InterPercentage + ", sapID="
				+ sapID + "]";
	}
	
	
}
