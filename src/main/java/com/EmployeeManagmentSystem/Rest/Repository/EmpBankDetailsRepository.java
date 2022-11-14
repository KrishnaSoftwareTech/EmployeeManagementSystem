package com.EmployeeManagmentSystem.Rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmployeeManagmentSystem.Rest.Model.EmpBankDetails;

/**
 * @author krishnakumar
 *
 */
public interface EmpBankDetailsRepository extends JpaRepository<EmpBankDetails, Long> {

}
