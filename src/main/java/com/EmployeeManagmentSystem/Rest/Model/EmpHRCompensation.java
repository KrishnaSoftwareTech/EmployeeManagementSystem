package com.EmployeeManagmentSystem.Rest.Model;

import java.sql.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class EmpHRCompensation {

	
	private Date ReleaseDate;
	private String CompesationType;
	/**
	 * @param releaseDate
	 * @param compesationType
	 */
	public EmpHRCompensation(Date releaseDate, String compesationType) {
		super();
		ReleaseDate = releaseDate;
		CompesationType = compesationType;
	}
	
	public EmpHRCompensation() {
		
	}

	public Date getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}

	public String getCompesationType() {
		return CompesationType;
	}

	public void setCompesationType(String compesationType) {
		CompesationType = compesationType;
	}
	
}
