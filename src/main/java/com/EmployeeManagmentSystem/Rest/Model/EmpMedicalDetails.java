package com.EmployeeManagmentSystem.Rest.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Embeddable
@Entity
public class EmpMedicalDetails {

	@Id 
	 private Long sapId;
	 @OneToOne(targetEntity=MedicalDependents.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	 @JsonBackReference
	private List<MedicalDependents> MedicateDependents;
	

	public EmpMedicalDetails(List<MedicalDependents> medicateDependents,Long sapid) {
		super();
	//	Id = id;
		MedicateDependents = medicateDependents;
		sapId=sapid;
	}
	public EmpMedicalDetails() {
		super();
	}
//	public Long getId() {
//		return Id;
//	}
	public Long getSapId() {
		return sapId;
	}
	public void setSapId(Long sapId) {
		this.sapId = sapId;
	}
//	public void setId(Long id) {
//		Id = id;
//	}
	public List<MedicalDependents> getMedicateDependents() {
		return MedicateDependents;
	}
	public void setMedicateDependents(List<MedicalDependents> medicateDependents) {
		MedicateDependents = medicateDependents;
	}
}
