package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="emp_family_Details")
public class FamilyDetails{
	@Id
	private Long id;
	private String Name;
	private String Occupation;
	private String Relation;
	@JsonBackReference
	@ManyToOne(targetEntity=EmpPersonalDetails.class, fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private EmpPersonalDetails personalDetails;
	
	public FamilyDetails() {
		super();
		
	}
	/**
	 * @param id
	 * @param name
	 * @param occupation
	 * @param relation
	 * @param personalDetails
	 */
	public FamilyDetails(Long id, String name, String occupation, String relation, EmpPersonalDetails personalDetails) {
		super();
		this.id = id;
		Name = name;
		Occupation = occupation;
		Relation = relation;
		this.personalDetails = personalDetails;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getOccupation() {
		return Occupation;
	}


	public void setOccupation(String occupation) {
		Occupation = occupation;
	}


	public String getRelation() {
		return Relation;
	}


	public void setRelation(String relation) {
		Relation = relation;
	}


	public EmpPersonalDetails getPersonalDetails() {
		return personalDetails;
	}


	public void setPersonalDetails(EmpPersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}
	
	
	}
