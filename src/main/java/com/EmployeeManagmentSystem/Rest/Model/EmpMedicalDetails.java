package com.EmployeeManagmentSystem.Rest.Model;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Embeddable
@Entity
public class EmpMedicalDetails {

	@Id 
	private Long Id;
	 @OneToOne(targetEntity=MedicalDependents.class, fetch=FetchType.EAGER)
	private List<MedicalDependents> MedicateDependents;
	/**
	 * @param sapId
	 * @param medicateDependents
	 */
	public EmpMedicalDetails(Long sapId, List<MedicalDependents> medicateDependents) {
		super();
		Id = sapId;
		MedicateDependents = medicateDependents;
	}
	public Long getSapId() {
		return Id;
	}
	public void setSapId(Long sapId) {
		Id = sapId;
	}
	public List<MedicalDependents> getMedicateDependents() {
		return MedicateDependents;
	}
	public void setMedicateDependents(List<MedicalDependents> medicateDependents) {
		MedicateDependents = medicateDependents;
	}
}
