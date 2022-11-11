package com.EmployeeManagmentSystem.Rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;
import com.EmployeeManagmentSystem.Rest.Model.FamilyDetails;

/**
 * @author krishnakumar
 *
 */
public interface EmpFamilyDetailsRepository extends JpaRepository<FamilyDetails, Long> {

}
