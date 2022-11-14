package com.EmployeeManagmentSystem.Rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;
import com.EmployeeManagmentSystem.Rest.Model.EmpEducationDetails;

/**
 * @author krishnakumar
 *
 */
public interface EmpEducationDetailsRepository extends JpaRepository<EmpEducationDetails, Long> {

}
