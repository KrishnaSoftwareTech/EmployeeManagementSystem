package com.EmployeeManagmentSystem.Rest.ServiceInterface;

import com.EmployeeManagmentSystem.Rest.Model.FamilyDetails;

/**
 * @author krishnakumar
 *
 */
public interface FamilyDetailsInterface {

	public FamilyDetails getFamilyInfo(Long sapId);

	public FamilyDetails addFamilyInfo(FamilyDetails familyInfo, Long sapId);

}
