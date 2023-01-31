package com.EmployeeManagmentSystem.Rest.Model;

import java.sql.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeCompensation")
public class EmpHRCompensation {

	@Override
	public String toString() {
		return "EmpHRCompensation [sapId=" + sapId + ", ReleaseDate=" + ReleaseDate + ", CompesationType="
				+ CompesationType + "]";
	}

	@Id
	private Long sapId;
	private Date ReleaseDate;
	private String CompesationType;
	
	/**
	 * @param sapId
	 * @param releaseDate
	 * @param compesationType
	 */
	public EmpHRCompensation(Long sapId, Date releaseDate, String compesationType) {
		super();
		this.sapId = sapId;
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

	public Long getSapId() {
		return sapId;
	}

	public void setSapId(Long sapId) {
		this.sapId = sapId;
	}

	public String getCompesationType() {
		return CompesationType;
	}

	public void setCompesationType(String compesationType) {
		CompesationType = compesationType;
	}
	
}
