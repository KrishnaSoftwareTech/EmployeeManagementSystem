package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author krishnakumar
 *
 */
@Entity
@Embeddable
public class Graduation {

	@Id
	private Long id;
	private String GraduationBoard;
	private String GraduationUniversityName;
	private String Country;
	private int Graduationpercentage;
	
	public Graduation(){
		}

	/**
	 * @param graduationBoard
	 * @param graduationUniversityName
	 * @param country
	 * @param graduationpercentage
	 */
	public Graduation(String graduationBoard, String graduationUniversityName, String country,
			int graduationpercentage) {
		super();
		GraduationBoard = graduationBoard;
		GraduationUniversityName = graduationUniversityName;
		Country = country;
		Graduationpercentage = graduationpercentage;
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
	
	
}
