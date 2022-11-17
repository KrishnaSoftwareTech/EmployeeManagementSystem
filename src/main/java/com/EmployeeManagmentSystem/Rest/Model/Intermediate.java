package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author krishnakumar
 *
 */
@Entity  
@Embeddable
public class Intermediate {

	@Id
	private Long CollegeId;
	private String InterBoard;
	private String InterUniversityName;
	private String Country;
	private int InterPercentage;
	@OneToOne(targetEntity=EducationDetails.class,  fetch=FetchType.EAGER)
	private EducationDetails sapID; 
	/**
	 * @param interBoard
	 * @param interUniversityName
	 * @param country
	 * @param interPercentage
	 */
	public Intermediate(String interBoard, String interUniversityName, String country, int interPercentage) {
		super();
		InterBoard = interBoard;
		InterUniversityName = interUniversityName;
		Country = country;
		InterPercentage = interPercentage;
	}
	
	public Intermediate() {
		
	}

	public String getInterBoard() {
		return InterBoard;
	}

	public void setInterBoard(String interBoard) {
		InterBoard = interBoard;
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
	
	
}
