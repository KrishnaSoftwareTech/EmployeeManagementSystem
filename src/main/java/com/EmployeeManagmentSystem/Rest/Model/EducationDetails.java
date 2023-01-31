package com.EmployeeManagmentSystem.Rest.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Embeddable
@Entity
@Table(name="EducationDetails")
public class EducationDetails {

//	@Override
//	public String toString() {
//		return "EducationDetails [sapId=" + sapId + ", School=" + School + ", intermedite=" + intermedite
//				+ ", graduation=" + graduation + "]";
//	}
	@Id
	private Long sapId;
    @JsonManagedReference
    @OneToOne(targetEntity=PrimarySchool.class,  fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
	 private PrimarySchool School;
    @JsonManagedReference
    @OneToOne(targetEntity=Intermediate.class, fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
	  private Intermediate intermedite;
    @JsonManagedReference
    @OneToOne(targetEntity=Graduation.class, fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
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
//	public void setGraduation(Long geaduation_id) {
//	}
//	public void setIntermedite(Long collegeId) {
//	}
//	public void setSchool(Long school_Id) {
//	}
	  
}
