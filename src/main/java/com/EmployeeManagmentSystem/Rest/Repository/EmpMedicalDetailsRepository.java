package com.EmployeeManagmentSystem.Rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;
import com.EmployeeManagmentSystem.Rest.Model.EmpMedicalDetails;

/**
 * @author krishnakumar
 *
 */
public interface EmpMedicalDetailsRepository extends JpaRepository<EmpMedicalDetails, Long> {

}
