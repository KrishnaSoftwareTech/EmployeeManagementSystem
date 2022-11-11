package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicalDependents{
	@Id
	private Long id;
	private String DependentName;
	private String DependentRelation;
	private int DependentAge;
	/**
	 * @param dependentName
	 * @param dependentRelation
	 * @param dependentAge
	 */
	public MedicalDependents(String dependentName, String dependentRelation, int dependentAge) {
		super();
		DependentName = dependentName;
		DependentRelation = dependentRelation;
		DependentAge = dependentAge;
	}
	public MedicalDependents() {
		
	}
	public String getDependentName() {
		return DependentName;
	}
	public void setDependentName(String dependentName) {
		DependentName = dependentName;
	}
	public String getDependentRelation() {
		return DependentRelation;
	}
	public void setDependentRelation(String dependentRelation) {
		DependentRelation = dependentRelation;
	}
	public int getDependentAge() {
		return DependentAge;
	}
	public void setDependentAge(int dependentAge) {
		DependentAge = dependentAge;
	}
	
}