package com.EmployeeManagmentSystem.Rest.Model;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Embeddable
@Entity
public class EmpEducationDetails {

	@Id
	private Long Id;
	  @OneToOne(targetEntity=PrimarySchool.class,  fetch=FetchType.EAGER)
	  private List<PrimarySchool> School;
	  @OneToOne(targetEntity=Intermediate.class, fetch=FetchType.EAGER)
	  private List<Intermediate> intermedite;
	  @OneToOne(targetEntity=Graduation.class, fetch=FetchType.EAGER)
	  private List<Graduation> graduation;
	/**
	 * @param school
	 * @param intermedite
	 * @param graduation
	 */
	public EmpEducationDetails(List<PrimarySchool> school, List<Intermediate> intermedite,
			List<Graduation> graduation) {
		super();
		School = school;
		this.intermedite = intermedite;
		this.graduation = graduation;
	}
	public EmpEducationDetails() {
		super();
	}
	//
	public List<PrimarySchool> getSchool() {
		return School;
	}
	public void setSchool(List<PrimarySchool> school) {
		School = school;
	}
	public List<Intermediate> getIntermedite() {
		return intermedite;
	}
	public void setIntermedite(List<Intermediate> intermedite) {
		this.intermedite = intermedite;
	}
	public List<Graduation> getGraduation() {
		return graduation;
	}
	public void setGraduation(List<Graduation> graduation) {
		this.graduation = graduation;
	}
	  
}
