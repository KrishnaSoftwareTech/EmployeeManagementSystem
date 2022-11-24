package com.EmployeeManagmentSystem.Rest.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class MedicalDependents{
	@Id
	private Long id;
	private String DependentName;
	private String DependentRelation;
	private int DependentAge;
	
	@ManyToOne(targetEntity=EmpMedicalDetails.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	 @JsonManagedReference 
	@JoinColumn(name="Employee_sapId")
	private EmpMedicalDetails empMedicalDetails;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public EmpMedicalDetails getEmpMedicalDetails() {
		return empMedicalDetails;
	}
	@JsonIgnore
	public void setEmpMedicalDetails(EmpMedicalDetails empMedicalDetails) {
		this.empMedicalDetails = empMedicalDetails;
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