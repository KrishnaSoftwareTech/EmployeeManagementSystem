package com.EmployeeManagmentSystem.Rest.Model;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Embeddable
@Entity
@Table(name="EducationDetails")
public class EducationDetails {

	@Id
	private Long sapId;
	 @OneToOne(targetEntity=PrimarySchool.class,  fetch=FetchType.EAGER)
	 private PrimarySchool School;
     @OneToOne(targetEntity=Intermediate.class, fetch=FetchType.EAGER)
	  private Intermediate intermedite;
     @OneToOne(targetEntity=Graduation.class, fetch=FetchType.EAGER)
	 private Graduation graduation;
		/**
		 * @param sapId
		 * @param school
		 * @param intermedite
		 * @param graduation
		 */
		public EducationDetails(Long sapId, PrimarySchool school, Intermediate intermedite,
				Graduation graduation) {
			super();
			this.sapId = sapId;
			School = school;
			this.intermedite = intermedite;
			this.graduation = graduation;
		}
	public EducationDetails() {
		super();
	}
	//
	 public Long getSapId() {
			return sapId;
		}
		public void setSapId(Long sapId) {
			this.sapId = sapId;
		}
	public PrimarySchool getSchool() {
		return School;
	}
	public void setSchool(PrimarySchool school) {
		School = school;
	}
	public Intermediate getIntermedite() {
		return intermedite;
	}
	public void setIntermedite(Intermediate intermedite) {
		this.intermedite = intermedite;
	}
	public Graduation getGraduation() {
		return graduation;
	}
	public void setGraduation(Graduation graduation) {
		this.graduation = graduation;
	}
//	public void addEmployeeEducationinfo(Long sapId2, EducationDetails educationDetails) {
//	}
	  
}
