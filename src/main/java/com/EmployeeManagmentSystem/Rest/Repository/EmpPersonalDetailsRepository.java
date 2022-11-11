package com.EmployeeManagmentSystem.Rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;
import com.EmployeeManagmentSystem.Rest.Model.EmpPersonalDetails;

/**
 * @author krishnakumar
 *
 */
public interface EmpPersonalDetailsRepository extends JpaRepository<EmpPersonalDetails, Long> {

}
