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
public class Graduation {

	@Id
//	@GeneratedValue
	private Long geaduation_id;
	private String GraduationBoard;
	private String GraduationUniversityName;
	private String Country;
	private int Graduationpercentage;
	@OneToOne(targetEntity=EducationDetails.class,  fetch=FetchType.EAGER)
	@JsonBackReference
	private EducationDetails sapID; 
	public Graduation(){
		}

//    "graduation": {
//    "graduationUniversityName": "St.Mark Educational Institutions",
//    "graduationBoard": "JNTU-Anantapur",
//    "graduationpercentage": 78,
//    "country": "India"
//},
	/**
	 * @param graduationBoard
	 * @param graduationUniversityName
	 * @param country
	 * @param graduationpercentage
	 */
//	public Graduation(String graduationBoard, String graduationUniversityName, String country,
//			int graduationpercentage) {
//		super();
//		GraduationBoard = graduationBoard;
//		GraduationUniversityName = graduationUniversityName;
//		Country = country;
//		Graduationpercentage = graduationpercentage;
//	}
	

	/**
	 * @param geaduation_id
	 * @param graduationBoard
	 * @param graduationUniversityName
	 * @param country
	 * @param graduationpercentage
	 * @param sapID
	 */
	public Graduation(Long geaduation_id, String graduationBoard, String graduationUniversityName, String country,
			int graduationpercentage, EducationDetails sapID) {
		super();
		this.geaduation_id = geaduation_id;
		GraduationBoard = graduationBoard;
		GraduationUniversityName = graduationUniversityName;
		Country = country;
		Graduationpercentage = graduationpercentage;
		this.sapID = sapID;
	}

	public Long getGeaduation_id() {
	return geaduation_id;
	}

	public void setGeaduation_id(Long geaduation_id) {
		this.geaduation_id = geaduation_id;
	}

	public EducationDetails getSapID() {
		return sapID;
	}

	public void setSapID(EducationDetails sapID) {
		this.sapID = sapID;
	}

	public String getGraduationBoard() {
		return GraduationBoard;
	}

	public void setGraduationBoard(String graduationBoard) {
		GraduationBoard = graduationBoard;
	}

	public String getGraduationUniversityName() {
		return GraduationUniversityName;
	}

	public void setGraduationUniversityName(String graduationUniversityName) {
		GraduationUniversityName = graduationUniversityName;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public int getGraduationpercentage() {
		return Graduationpercentage;
	}

	public void setGraduationpercentage(int graduationpercentage) {
		Graduationpercentage = graduationpercentage;
	}

	@Override
	public String toString() {
		return "Graduation [geaduation_id=" + geaduation_id + ", GraduationBoard=" + GraduationBoard
				+ ", GraduationUniversityName=" + GraduationUniversityName + ", Country=" + Country
				+ ", Graduationpercentage=" + Graduationpercentage + ", sapID=" + sapID + "]";
	}
	
	
}
