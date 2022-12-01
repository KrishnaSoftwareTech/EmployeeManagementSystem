package com.EmployeeManagmentSystem.Rest.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Embeddable
@Entity
public class EmpMedicalDetails {

	@Id 
	 private Long sapId;
	 @OneToMany(targetEntity=MedicalDependents.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	 @JsonManagedReference 
	 @Column(name="dependents")
	private List<MedicalDependents> MedicalDependents;
	//
	 
	/**
	 * @param sapId
	 * @param medicateDependents
	 */
	public EmpMedicalDetails(Long sapId, List<MedicalDependents> medicateDependents) {
		super();
		this.sapId = sapId;
		MedicalDependents = medicateDependents;
	}
	public EmpMedicalDetails() {
		super();
	}
	public Long getSapId() {
		return sapId;
	}
	public void setSapId(Long sapId) {
		this.sapId = sapId;
	}
	@JsonIgnore
	public List<MedicalDependents> getMedicateDependents() {
		return MedicalDependents;
	}
	public void setMedicateDependents(List<MedicalDependents> medicalDependent) {
		MedicalDependents = medicalDependent;
	}
	 
}
