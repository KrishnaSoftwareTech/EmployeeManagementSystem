package com.EmployeeManagmentSystem.Rest.ServiceInterface;

import com.EmployeeManagmentSystem.Rest.Model.EmpMedicalDetails;

public interface MedicalDetailsInterface {

	public EmpMedicalDetails addMedicalInformation(EmpMedicalDetails medicalDetails, Long sapId);

	public EmpMedicalDetails getInfoByid(Long sapId);

	public EmpMedicalDetails updateMedicalInformation(EmpMedicalDetails medicalDetails, Long sapId);
	
	public void deleteMedicalInformation(Long sapId);

	

}
