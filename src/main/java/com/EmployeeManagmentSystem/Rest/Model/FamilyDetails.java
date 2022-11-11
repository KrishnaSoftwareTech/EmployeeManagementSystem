package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FamilyDetails{
	@Id
	private Long id;
	private String Name;
	private String Occupation;
	private String Relation;
	/**
	 * @param name
	 * @param occupation
	 * @param relation
	 */
	public FamilyDetails(String name, String occupation, String relation) {
		super();
		Name = name;
		Occupation = occupation;
		Relation = relation;
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

	
	}
